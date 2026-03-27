package interview.craftsman.question8;

/**
 * INTERVIEW QUESTION 8 — Original (smelly) code.
 *
 * Scenario: a text processor that applies transformations to a string.
 * New requirements keep adding new combinations of transformations.
 */
public class Question8Original {

    static class TextProcessor {
        public String process(String text) {
            return text;
        }
    }

    // need trim → extend base
    static class TrimTextProcessor extends TextProcessor {
        public String process(String text) {
            return super.process(text).trim();
        }
    }

    // need trim + uppercase → extend trim
    static class UpperCaseTrimTextProcessor extends TrimTextProcessor {
        public String process(String text) {
            return super.process(text).toUpperCase();
        }
    }

    // need trim + uppercase + remove special chars → extend again
    static class SanitizedUpperCaseTrimTextProcessor extends UpperCaseTrimTextProcessor {
        public String process(String text) {
            return super.process(text).replaceAll("[^a-zA-Z0-9 ]", "");
        }
    }

    // but now someone needs ONLY uppercase + remove special chars, without trim
    // → another class needed...
    static class SanitizedUpperCaseTextProcessor extends TextProcessor {
        public String process(String text) {
            return super.process(text).toUpperCase().replaceAll("[^a-zA-Z0-9 ]", "");
        }
    }

    // and someone needs ONLY trim + remove special chars, without uppercase
    // → yet another class...
    static class SanitizedTrimTextProcessor extends TrimTextProcessor {
        public String process(String text) {
            return super.process(text).replaceAll("[^a-zA-Z0-9 ]", "");
        }
    }
}
