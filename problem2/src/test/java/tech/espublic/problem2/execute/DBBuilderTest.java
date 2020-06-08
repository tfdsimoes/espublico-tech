package tech.espublic.problem2.execute;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
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
import tech.espublic.problem2.util.AuxiliarBuilderObjects;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DBBuilderTest {

    private WebClientRequester webClientRequester;

    private FilmRepository filmRepository;

    private PeopleRepository peopleRepository;

    private StarshipRepository starshipRepository;

    private StarshipPeopleRepository starshipPeopleRepository;

    private FilmPeopleRepository filmPeopleRepository;

    private FilmStarshipRepository filmStarshipRepository;

    private DBBuilder dbBuilder;

    @BeforeEach
    public void setUp() {
        this.webClientRequester = mock(WebClientRequester.class);
        this.filmRepository = mock(FilmRepository.class);
        this.peopleRepository = mock(PeopleRepository.class);
        this.starshipRepository = mock(StarshipRepository.class);
        this.starshipPeopleRepository = mock(StarshipPeopleRepository.class);
        this.filmPeopleRepository = mock(FilmPeopleRepository.class);
        this.filmStarshipRepository = mock(FilmStarshipRepository.class);

        this.dbBuilder = new DBBuilder(webClientRequester, filmRepository, peopleRepository, starshipRepository,
                starshipPeopleRepository, filmPeopleRepository, filmStarshipRepository);
    }

    /**
     * Test for insertion in the database without relations
     */
    @Disabled("not full implemented")
    @Test
    void buildDWithNoRelations() {
        OtherApisResource otherApisResource = AuxiliarBuilderObjects.buildDefaultOtherApisResource();
        FilmPaginationResource filmPaginationResource = AuxiliarBuilderObjects.buildDefaultFilmPaginationResource();
        PeoplePaginationResource peoplePaginationResource = AuxiliarBuilderObjects.buildDefaultPeoplePaginationResource();
        StarshipPaginationResource starshipPaginationResource = AuxiliarBuilderObjects.buildDefaultStarshipPaginationResource();

        when(webClientRequester.getOtherApis()).thenReturn(otherApisResource);
        when(webClientRequester.getFilms(eq(otherApisResource.getFilms()))).thenReturn(filmPaginationResource);
        when(webClientRequester.getPeople(eq(otherApisResource.getPeople()))).thenReturn(peoplePaginationResource);
        when(webClientRequester.getStarships(eq(otherApisResource.getStarships()))).thenReturn(starshipPaginationResource);

        // TODO - add more whens and verify

        dbBuilder.buildDB();

        verify(webClientRequester, times(1)).getOtherApis();
        verify(webClientRequester, times(1)).getFilms(otherApisResource.getFilms());
        verify(webClientRequester, times(1)).getStarships(otherApisResource.getStarships());
        verify(webClientRequester, times(1)).getPeople(otherApisResource.getPeople());
    }


}
