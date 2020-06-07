package tech.espublic.problem2.execute;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tech.espublic.problem2.service.AnswerUserRequest;

/**
 * Main class of the application
 */
@Component
@Slf4j
public class Problem2Service implements CommandLineRunner {

    private final DBBuilder dbBuilder;

    private final AnswerUserRequest answerUserRequest;

    public Problem2Service(DBBuilder dbBuilder, AnswerUserRequest answerUserRequest) {
        this.dbBuilder = dbBuilder;
        this.answerUserRequest = answerUserRequest;
    }

    @Override
    public void run(String... args) {
        log.info("Running application");
        dbBuilder.buildDB();
        answerUserRequest.waitingQueries();
        System.exit(0);
    }

}
