package tech.espublic.problem2.execute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import tech.espublic.problem2.domain.Film;
import tech.espublic.problem2.domain.FilmPeople;
import tech.espublic.problem2.domain.FilmStarship;
import tech.espublic.problem2.domain.People;
import tech.espublic.problem2.domain.Starship;
import tech.espublic.problem2.domain.StarshipPeople;
import tech.espublic.problem2.mapper.FilmMapper;
import tech.espublic.problem2.mapper.PeopleMapper;
import tech.espublic.problem2.mapper.StarshipMapper;
import tech.espublic.problem2.repository.FilmPeopleRepository;
import tech.espublic.problem2.repository.FilmRepository;
import tech.espublic.problem2.repository.FilmStarshipRepository;
import tech.espublic.problem2.repository.PeopleRepository;
import tech.espublic.problem2.repository.StarshipPeopleRepository;
import tech.espublic.problem2.repository.StarshipRepository;
import tech.espublic.problem2.restClient.requester.WebClientRequester;
import tech.espublic.problem2.restClient.resources.OtherApisResource;
import tech.espublic.problem2.restClient.resources.film.FilmPaginationResource;
import tech.espublic.problem2.restClient.resources.people.PeoplePaginationResource;
import tech.espublic.problem2.restClient.resources.starship.StarshipPaginationResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class that will handles the build of DB based on the information of external APIs
 */
@Component
@Slf4j
public class DBBuilder {

    private final WebClientRequester webClientRequester;

    private final FilmRepository filmRepository;

    private final PeopleRepository peopleRepository;

    private final StarshipRepository starshipRepository;

    private final StarshipPeopleRepository starshipPeopleRepository;

    private final FilmPeopleRepository filmPeopleRepository;

    private final FilmStarshipRepository filmStarshipRepository;

    public DBBuilder(WebClientRequester webClientRequester, FilmRepository filmRepository, PeopleRepository peopleRepository,
                     StarshipRepository starshipRepository, StarshipPeopleRepository starshipPeopleRepository,
                     FilmPeopleRepository filmPeopleRepository, FilmStarshipRepository filmStarshipRepository) {
        this.webClientRequester = webClientRequester;
        this.filmRepository = filmRepository;
        this.peopleRepository = peopleRepository;
        this.starshipRepository = starshipRepository;
        this.starshipPeopleRepository = starshipPeopleRepository;
        this.filmPeopleRepository = filmPeopleRepository;
        this.filmStarshipRepository = filmStarshipRepository;
    }

    /**
     * Function that will launch the build of the db by steps
     */
    @Transactional
    public void buildDB() {
        log.info("Starting building DB");

        OtherApisResource otherApisResource = webClientRequester.getOtherApis();

        buildPeopleDB(otherApisResource.getPeople());
        buildStartshipDB(otherApisResource.getStarships());
        buildFilmDB(otherApisResource.getFilms());
    }

    /**
     * Function that will handle film into db
     *
     * @param url Url to get the films
     */
    private void buildFilmDB(String url) {
        log.info("Starting building film DB");

        boolean next = true;

        while (next) {
            FilmPaginationResource filmPaginationResource = webClientRequester.getFilms(url);

            filmPaginationResource.getResults().forEach(
                    filmResource -> {
                        Film film = filmRepository.save(FilmMapper.INSTANCE.filmResourceToFilm(filmResource));

                        buildRelationsFilmToStarshipAndPeople(film, filmResource.getCharacters(), filmResource.getStarships());
                    }
            );

            if (Optional.ofNullable(filmPaginationResource.getNext()).isPresent()) {
                next = true;
                url = filmPaginationResource.getNext();
            } else {
                next = false;
            }
        }
    }

    /**
     * Function that will handle people into db
     *
     * @param url Url to get the people
     */
    private void buildPeopleDB(String url) {
        log.info("Starting building people DB");

        boolean next = true;

        while (next) {
            PeoplePaginationResource peoplePaginationResource = webClientRequester.getPeople(url);

            List<People> peopleList = PeopleMapper.INSTANCE.peopleResourceListToPeopleList(peoplePaginationResource.getResults());

            peopleRepository.saveAll(peopleList);

            if (Optional.ofNullable(peoplePaginationResource.getNext()).isPresent()) {
                next = true;
                url = peoplePaginationResource.getNext();
            } else {
                next = false;
            }
        }
    }

    /**
     * Function that will handle starship into db
     *
     * @param url Url to get the startship
     */
    private void buildStartshipDB(String url) {
        log.info("Starting building startship DB");

        boolean next = true;

        while (next) {
            StarshipPaginationResource starshipPaginationResource = webClientRequester.getStarships(url);

            starshipPaginationResource.getResults()
                    .forEach(starshipResource -> {
                                Starship starship = starshipRepository
                                        .save(StarshipMapper.INSTANCE.starshipResourceToStarship(starshipResource));

                                buildRelationsStarshipToPeople(starship, starshipResource.getPilots());
                            }
                    );

            if (Optional.ofNullable(starshipPaginationResource.getNext()).isPresent()) {
                next = true;
                url = starshipPaginationResource.getNext();
            } else {
                next = false;
            }
        }

    }

    /**
     * Function that will build relations between starship and people
     *
     * @param starship     Object in the database
     * @param pilotUrlList List of url pilots from external source
     */
    private void buildRelationsStarshipToPeople(Starship starship, List<String> pilotUrlList) {
        log.info("Building relation starship {}", starship.getId());

        List<StarshipPeople> starshipPeopleList = new ArrayList<>();

        peopleRepository.findAllByUrlIn(pilotUrlList).forEach(
                people -> starshipPeopleList.add(StarshipPeople.builder().people(people).starship(starship).build())
        );

        starshipPeopleRepository.saveAll(starshipPeopleList);
    }

    /**
     * Function that will build relations between film and starship and film and people
     *
     * @param film          Object in the database
     * @param characterList List of url character from external source
     * @param starshipList  List of url starship from external source
     */
    private void buildRelationsFilmToStarshipAndPeople(Film film, List<String> characterList, List<String> starshipList) {
        log.info("Building relations film {}", film.getId());

        List<FilmPeople> filmPeopleList = new ArrayList<>();
        List<FilmStarship> filmStarshipList = new ArrayList<>();

        starshipRepository.findAllByUrlIn(starshipList).forEach(
                starship -> filmStarshipList.add(FilmStarship.builder().film(film).starship(starship).build())
        );

        peopleRepository.findAllByUrlIn(characterList).forEach(
                character -> filmPeopleList.add(FilmPeople.builder().film(film).people(character).build())
        );

        filmPeopleRepository.saveAll(filmPeopleList);
        filmStarshipRepository.saveAll(filmStarshipList);
    }

}
