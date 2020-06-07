package tech.espublic.problem2.restClient.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object that represents the answer of api about others apis
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtherApisResource {

    private String people;

    private String films;

    private String starships;
}
