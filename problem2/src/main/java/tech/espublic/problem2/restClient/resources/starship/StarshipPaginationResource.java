package tech.espublic.problem2.restClient.resources.starship;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.espublic.problem2.restClient.resources.common.ApiPaginationResource;

import java.util.List;

/**
 * Resource that represents starship from the api
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StarshipPaginationResource extends ApiPaginationResource {

    private List<StarshipResource> results;

    @Builder
    public StarshipPaginationResource(Integer count, String next, String previous, List<StarshipResource> results) {
        super(count, next, previous);
        this.results = results;
    }
}
