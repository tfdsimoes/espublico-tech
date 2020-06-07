package tech.espublic.problem2.util;

import tech.espublic.problem2.restClient.resources.OtherApisResource;
import tech.espublic.problem2.restClient.resources.film.FilmPaginationResource;
import tech.espublic.problem2.restClient.resources.film.FilmResource;
import tech.espublic.problem2.restClient.resources.people.PeoplePaginationResource;
import tech.espublic.problem2.restClient.resources.people.PeopleResource;
import tech.espublic.problem2.restClient.resources.starship.StarshipPaginationResource;
import tech.espublic.problem2.restClient.resources.starship.StarshipResource;

import java.time.LocalDate;
import java.util.Collections;

/**
 * Class that have aux methods to help to build objects
 */
public class AuxiliarBuilderObjects {

    /**
     * Aux function to help to build a default {@link OtherApisResource}
     * @return
     */
    public static OtherApisResource buildDefaultOtherApisResource() {
        return OtherApisResource.builder()
                .films("filmsAPIUrl")
                .people("peopleAPIUrl")
                .starships("starshipAPIUrl")
                .build();
    }

    /**
     * Aux function to help to build a default {@link FilmResource}
     *
     * @return {@link FilmResource}
     */
    public static FilmResource buildDefaultFilmResource() {
        return FilmResource.builder()
                .characters(Collections.emptyList())
                .director("director")
                .episodeId(1)
                .openingCrawl("openingCrawl")
                .producer("producer")
                .releaseDate(LocalDate.now())
                .starships(Collections.emptyList())
                .title("title")
                .build();
    }

    /**
     * Aux function to help build a default {@link FilmPaginationResource}
     *
     * @return {@link FilmPaginationResource}
     */
    public static FilmPaginationResource buildDefaultFilmPaginationResource() {
        return FilmPaginationResource.builder()
                .count(1)
                .next(null)
                .previous(null)
                .results(Collections.singletonList(buildDefaultFilmResource()))
                .build();
    }

    /**
     * Aux function to help to build a default {@link PeopleResource}
     *
     * @return {@link PeopleResource}
     */
    public static PeopleResource buildDefaultPeopleResource() {
        return PeopleResource.builder()
                .birthYear("20BBY")
                .eyeColor("eyeColor")
                .gender("gender")
                .hairColor("hairColor")
                .height("100")
                .mass("100")
                .name("name")
                .skinColor("skinColor")
                .films(Collections.emptyList())
                .starships(Collections.emptyList())
                .build();
    }

    /**
     * Aux function to help build a default {@link PeoplePaginationResource}
     *
     * @return {@link PeoplePaginationResource}
     */
    public static PeoplePaginationResource buildDefaultPeoplePaginationResource() {
        return PeoplePaginationResource.builder()
                .count(1)
                .next(null)
                .previous(null)
                .results(Collections.singletonList(buildDefaultPeopleResource()))
                .build();
    }

    /**
     * Aux function to help to build a default {@link StarshipResource}
     *
     * @return {@link StarshipResource}
     */
    public static StarshipResource buildDefaultStarshipResource() {
        return StarshipResource.builder()
                .cargoCapacity("1000")
                .consumables("x months")
                .costInCredits("1000000000")
                .crew("100 - 200")
                .hyperdriveRating("2.0")
                .length("1000000000")
                .manufacturer("manufacturer")
                .maxAtmospheringSpeed("1000000")
                .MGLT("MGLT")
                .model("model")
                .name("name")
                .passengers("100 - 200")
                .starshipClass("starship class")
                .pilots(Collections.emptyList())
                .build();
    }

    /**
     * Aux function to help to build a default {@link StarshipPaginationResource}
     *
     * @return {@link StarshipPaginationResource}
     */
    public static StarshipPaginationResource buildDefaultStarshipPaginationResource() {
        return StarshipPaginationResource.builder()
                .count(1)
                .next(null)
                .previous(null)
                .results(Collections.singletonList(buildDefaultStarshipResource()))
                .build();
    }
}
