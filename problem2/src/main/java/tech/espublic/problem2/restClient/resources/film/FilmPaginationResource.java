package tech.espublic.problem2.restClient.resources.film;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.espublic.problem2.restClient.resources.common.ApiPaginationResource;

import java.util.List;

/**
 * Resource that handler the film with pagination
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmPaginationResource extends ApiPaginationResource {

    private List<FilmResource> results;

    @Builder
    public FilmPaginationResource(Integer count, String next, String previous, List<FilmResource> results) {
        super(count, next, previous);
        this.results = results;
    }
}
