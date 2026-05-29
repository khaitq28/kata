package interview.craftsman.question13;

import java.util.List;

/**
 * INTERVIEW QUESTION 13 — Original (smelly) code.
 *
 * Smells present:
 *  - Repeated null checks for an optional collaborator (Logger)
 *  - Violates OCP: every new log call needs another null guard
 *  - Null is not a valid abstraction — it carries no type-safe meaning
 *  - Null Object pattern missing: a "do-nothing" implementation would
 *    eliminate all guards and let the caller choose behaviour at construction
 */
public class Question13Original {

    interface Logger {
        void log(String message);
    }

    static class FileProcessor {

        private final Logger logger;    // may be null → guards everywhere

        public FileProcessor(Logger logger) {
            this.logger = logger;
        }

        public void process(List<String> lines) {
            if (logger != null) logger.log("Starting processing");

            for (String line : lines) {
                if (logger != null) logger.log("Processing: " + line);
                // ... actual processing ...
            }

            if (logger != null) logger.log("Processing complete. Lines: " + lines.size());
        }
    }
}
