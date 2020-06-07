package tech.espublic.problem2.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@Getter
@Setter
@MappedSuperclass
public class CommonDomain {

    private ZonedDateTime created;

    private ZonedDateTime edited;

    private String url;
}
