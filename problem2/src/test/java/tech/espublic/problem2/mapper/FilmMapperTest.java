package tech.espublic.problem2.mapper;

import org.junit.jupiter.api.Test;
import tech.espublic.problem2.domain.Film;
import tech.espublic.problem2.restClient.resources.film.FilmResource;
import tech.espublic.problem2.util.AuxiliarBuilderObjects;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Class that test the {@link FilmMapper}
 */
class FilmMapperTest {

    @Test
    void filmResourceToFilm() {
        FilmResource filmResource = AuxiliarBuilderObjects.buildDefaultFilmResource();

        Film film = FilmMapper.INSTANCE.filmResourceToFilm(filmResource);

        verifyFilmResourceAgainstFilm(filmResource, film);
    }

    @Test
    void filmResourceListToFilmList() {

        List<FilmResource> filmResourceList = new ArrayList<>();
        filmResourceList.add(AuxiliarBuilderObjects.buildDefaultFilmResource());
        filmResourceList.add(AuxiliarBuilderObjects.buildDefaultFilmResource());
        filmResourceList.add(AuxiliarBuilderObjects.buildDefaultFilmResource());

        List<Film> filmList = FilmMapper.INSTANCE.filmResourceListToFilmList(filmResourceList);

        for (int i = 0; i < filmList.size(); i++) {
            verifyFilmResourceAgainstFilm(filmResourceList.get(i), filmList.get(i));
        }
    }

    /**
     * Aux function to verify {@link FilmResource} agains {@link Film}
     *
     * @param filmResource {@link FilmResource}
     * @param film         {@link Film}
     */
    private void verifyFilmResourceAgainstFilm(FilmResource filmResource, Film film) {
        assertNull(film.getId());
        assertEquals(filmResource.getDirector(), film.getDirector());
        assertEquals(filmResource.getEpisodeId(), film.getEpisodeId());
        assertEquals(filmResource.getOpeningCrawl(), film.getOpeningCrawl());
        assertEquals(filmResource.getProducer(), film.getProducer());
        assertEquals(filmResource.getReleaseDate(), film.getReleaseDate());
        assertEquals(filmResource.getTitle(), film.getTitle());

        assertEquals(0, film.getFilmPeople().size());
        assertEquals(0, film.getFilmStarshipList().size());
    }
}
