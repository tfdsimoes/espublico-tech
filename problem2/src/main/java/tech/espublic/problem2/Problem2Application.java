package tech.espublic.problem2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import tech.espublic.problem2.execute.Problem2Service;

/**
 * Start class of application
 */
@SpringBootApplication
@EnableConfigurationProperties({Problem2Properties.class})
public class Problem2Application {

    private final Problem2Service service;

    public Problem2Application(Problem2Service service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Problem2Application.class, args);
    }
}
