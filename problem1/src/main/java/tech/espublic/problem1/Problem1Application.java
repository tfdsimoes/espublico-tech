package tech.espublic.problem1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({Problem1Properties.class})
public class Problem1Application {

    public static void main(String[] args) {
        SpringApplication.run(Problem1Application.class, args);
    }

}
