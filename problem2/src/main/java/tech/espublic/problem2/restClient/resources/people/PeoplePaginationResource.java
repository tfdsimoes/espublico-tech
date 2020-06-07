package tech.espublic.problem2.restClient.resources.people;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.espublic.problem2.restClient.resources.common.ApiPaginationResource;

import java.util.List;

/**
 * Resource that handler the people with pagination
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeoplePaginationResource extends ApiPaginationResource {

    private List<PeopleResource> results;

    @Builder
    public PeoplePaginationResource(Integer count, String next, String previous, List<PeopleResource> results) {
        super(count, next, previous);
        this.results = results;
    }
}
