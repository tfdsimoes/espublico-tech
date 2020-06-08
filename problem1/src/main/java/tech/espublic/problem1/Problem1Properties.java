package tech.espublic.problem1;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties( prefix = "problem2" )
public class Problem1Properties {
}
