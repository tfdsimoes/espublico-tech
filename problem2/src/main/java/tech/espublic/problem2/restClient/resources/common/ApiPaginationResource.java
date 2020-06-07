package tech.espublic.problem2.restClient.resources.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Common handler of pagination answer
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiPaginationResource {

    private Integer count;

    private String next;

    private String previous;
}
