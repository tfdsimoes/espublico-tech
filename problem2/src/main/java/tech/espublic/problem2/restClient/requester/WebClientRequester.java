package tech.espublic.problem2.restClient.requester;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import tech.espublic.problem2.Problem2Properties;
import tech.espublic.problem2.restClient.resources.OtherApisResource;
import tech.espublic.problem2.restClient.resources.film.FilmPaginationResource;
import tech.espublic.problem2.restClient.resources.people.PeoplePaginationResource;
import tech.espublic.problem2.restClient.resources.starship.StarshipPaginationResource;

import java.net.URI;

/**
 * Function that handles the http requests
 */
@Component
@Slf4j
public class WebClientRequester {

    private final WebClient webClient = WebClient.create();

    private final Problem2Properties properties;

    public WebClientRequester(Problem2Properties properties) {
        this.properties = properties;
    }

    /**
     * Function that retrieves the other apis from the external source
     *
     * @return {@link OtherApisResource}
     */
    public OtherApisResource getOtherApis() {
        log.info("Requesting other apis");
        return getRequest(properties.getStartWarsApiUrl()).bodyToMono(OtherApisResource.class).block();
    }

    /**
     * Function that retrieves people from the external source
     *
     * @param url Path to connect
     * @return {@link PeoplePaginationResource}
     */
    public PeoplePaginationResource getPeople(String url) {
        log.info("Requesting people");
        return getRequest(url).bodyToMono(PeoplePaginationResource.class).block();
    }

    /**
     * Function that retrieves films from the external source
     *
     * @param url Path to connect
     * @return {@link FilmPaginationResource}
     */
    public FilmPaginationResource getFilms(String url) {
        log.info("Requesting films");
        return getRequest(url).bodyToMono(FilmPaginationResource.class).block();
    }

    /**
     * Function that retrieves startships from the external source
     *
     * @param url Path to connect
     * @return {@link StarshipPaginationResource}
     */
    public StarshipPaginationResource getStarships(String url) {
        log.info("Requesting starships");
        return getRequest(url).bodyToMono(StarshipPaginationResource.class).block();
    }

    /**
     * Function that handles http get requests
     *
     * @param url local to make the request
     * @return {@link org.springframework.web.reactive.function.client.WebClient.ResponseSpec}
     */
    private WebClient.ResponseSpec getRequest(String url) {
        log.info("Getting from {}", url);
        return webClient.get().uri(URI.create(url)).retrieve();
    }
}
