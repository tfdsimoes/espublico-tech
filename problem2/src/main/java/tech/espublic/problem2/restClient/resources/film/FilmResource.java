package tech.espublic.problem2.restClient.resources.film;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.espublic.problem2.restClient.resources.common.CommonPropertiesResource;

import java.time.LocalDate;
import java.util.List;

/**
 * Resource that represents films from the api
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResource extends CommonPropertiesResource {

    @JsonProperty("title")
    private String title;

    @JsonProperty("episode_id")
    private Integer episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("director")
    private String director;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("starships")
    private List<String> starships;


}
