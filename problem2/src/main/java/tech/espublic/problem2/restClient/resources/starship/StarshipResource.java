package tech.espublic.problem2.restClient.resources.starship;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.espublic.problem2.restClient.resources.common.CommonPropertiesResource;

import java.util.List;

/**
 * Resource that represents starships from the api
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StarshipResource extends CommonPropertiesResource {

    @JsonProperty("name")
    private String name;

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("length")
    private String length;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("crew")
    private String crew;

    @JsonProperty("passengers")
    private String passengers;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    @JsonProperty("MGLT")
    private String MGLT;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("pilots")
    private List<String> pilots;
}
