package tech.espublic.problem2.restClient.resources.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

/**
 * Resource that handler common information of other resources
 */
@Getter
@Setter
public class CommonPropertiesResource {

    @JsonProperty("created")
    private ZonedDateTime created;

    @JsonProperty("edited")
    private ZonedDateTime edited;

    @JsonProperty("url")
    private String url;
}
