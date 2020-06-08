package tech.espublic.problem2;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Class that handles properties
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "problem2")
public class Problem2Properties {
    public String startWarsApiUrl;

}
