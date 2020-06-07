package tech.espublic.problem2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.espublic.problem2.repository.FilmPeopleRepository;
import tech.espublic.problem2.repository.FilmRepository;
import tech.espublic.problem2.repository.FilmStarshipRepository;
import tech.espublic.problem2.repository.PeopleRepository;
import tech.espublic.problem2.repository.StarshipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class that handles the request of user in command line
 */
@Service
@Slf4j
public class AnswerUserRequest {

    private final PeopleRepository peopleRepository;

    private final FilmRepository filmRepository;

    private final FilmStarshipRepository filmStarshipRepository;

    private final StarshipRepository starshipRepository;

    private final FilmPeopleRepository filmPeopleRepository;

    public AnswerUserRequest(PeopleRepository peopleRepository, FilmRepository filmRepository, FilmStarshipRepository filmStarshipRepository,
                             StarshipRepository starshipRepository, FilmPeopleRepository filmPeopleRepository) {
        this.peopleRepository = peopleRepository;
        this.filmRepository = filmRepository;
        this.filmStarshipRepository = filmStarshipRepository;
        this.starshipRepository = starshipRepository;
        this.filmPeopleRepository = filmPeopleRepository;
    }

    /**
     * Function of main menu
     */
    public void waitingQueries() {
        String option = "";
        boolean run = true;
        Scanner in = new Scanner(System.in);

        while (run) {
            System.out.println("----------------------");
            System.out.println("Select option:");
            System.out.println("1-List all character with the number of movies and their titles");
            System.out.println("2-Select movies to search characters that appear more driving in selected movies");
            System.out.println("3-Exit");

            option = in.next();

            switch (option) {
                case "1":
                    listAllCharactersWithMovies();
                    break;
                case "2":
                    charactersThatAppearMoreDriving();
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Insert the options in top");
                    break;
            }

        }
    }

    /**
     * Function that process the list of all characters with the movies
     */
    @Transactional(readOnly = true)
    public void listAllCharactersWithMovies() {
        log.info("Process characters of movies");
        peopleRepository.findAll().forEach(
                people -> {
                    System.out.printf("Character %s total of films %d:\n", people.getName(), people.getFilmPeopleList().size());
                    people.getFilmPeopleList().forEach(filmPeople -> {
                        System.out.printf("\t\t - %s\n", filmPeople.getFilm().getTitle());
                    });
                }
        );

        /* These is the best way ... but some problem that I do not know is happening
        try (Stream<People> peopleStream = peopleRepository.readAllBy()) {
            peopleStream.forEach(people -> {});
        }
         */
    }

    /**
     * Function that process the starship that appears more in the movies select and who drives it
     */
    @Transactional(readOnly = true)
    void charactersThatAppearMoreDriving() {
        log.info("Process most appear ship of movies and who drove");

        List<String> orderShowFilmId = new ArrayList<>();
        List<String> selectionFilmId = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        AtomicInteger maxAppears = new AtomicInteger(-1);

        System.out.println("Movies list: (inserted separated by comas without space [ex: x,x,x,x])");
        filmRepository.findAll().forEach(
                film -> {
                    orderShowFilmId.add(film.getId());
                    System.out.printf("%d - %s\n", orderShowFilmId.size(), film.getTitle());
                }
        );

        for (String movieSelected : in.next().split(",")) {
            try {
                selectionFilmId.add(orderShowFilmId.get(Integer.parseInt(movieSelected) - 1));
            } catch (NumberFormatException exception) {
                System.out.println("Bad selection");
                return;
            }
        }

        // Get people in the films
        List<FilmPeopleRepository.PeopleIdName> peopleIdNameListInFilmsSelected = filmPeopleRepository.findAllPeopleByFilmIdIn(selectionFilmId);

        // Get top of starships that appears
        filmStarshipRepository.getStarshipWithMoreAppearsBasedOnFilm(selectionFilmId).forEach(
                filmStarshipCounter -> {
                    if (maxAppears.get() > filmStarshipCounter.getCounter()) {
                        return;
                    }

                    maxAppears.set(filmStarshipCounter.getCounter());

                    starshipRepository.findById(filmStarshipCounter.getStarshipId()).ifPresent(
                            starship -> {
                                System.out.printf("Starship name %s\n", starship.getName());
                                starship.getStarshipPeopleList().forEach(
                                        starshipPeople -> {
                                            String namePeople = checkNameFromPeopleInFilms(peopleIdNameListInFilmsSelected, starshipPeople.getPeople().getId());

                                            if (!namePeople.equals("")) {
                                                System.out.printf("\t\t - %s\n", namePeople);
                                            }
                                        }
                                );
                            }

                    );
                }
        );
    }

    /**
     * Aux function to process people id to people name based on a list
     *
     * @param peopleIdNameListInFilmsSelected list with ids and names
     * @param peopleId                        id to convert to name
     * @return the name or ""
     */
    private String checkNameFromPeopleInFilms(List<FilmPeopleRepository.PeopleIdName> peopleIdNameListInFilmsSelected, String peopleId) {
        for (FilmPeopleRepository.PeopleIdName peopleIdName : peopleIdNameListInFilmsSelected) {
            if (peopleIdName.getId().equals(peopleId)) {
                return peopleIdName.getName();
            }
        }
        return "";
    }
}
