package tech.espublic.problem1.executer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import tech.espublic.problem1.file_processing.FileProcessor;

/**
 * Main class of the application
 */
@Service
@Slf4j
public class Problem1Service implements CommandLineRunner {

    private final FileProcessor fileProcessor;

    private final ResumeData resumeData;

    public Problem1Service(FileProcessor fileProcessor, ResumeData resumeData) {
        this.fileProcessor = fileProcessor;
        this.resumeData = resumeData;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Starting application");

        if (args.length != 1) {
            throw new RuntimeException("Missing path of file");
        }

        String pathToFile = args[0];

        log.info("Path of file: {}", pathToFile);
        fileProcessor.processFile(pathToFile);

        log.info("Making queries for resume of data");
        resumeData.showResumeOfData();

        System.exit(0);
    }
}
