package interview.craftsman.question13;

import java.util.List;
import java.util.Objects;

public class FileProcessor {

    private final Logger logger;

    public FileProcessor(Logger logger) {
        this.logger = Objects.requireNonNull(logger, "Logger cannot be null");
    }

    public void process(List<String> lines) {
        logger.log("Starting processing");
        for (String line : lines) {
            logger.log("Processing: " + line);
        }
        logger.log("Processing complete. Lines: " + lines.size());
    }
}
