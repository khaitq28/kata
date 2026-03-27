package interview.craftsman.question8;

/**
 * INTERVIEW QUESTION 8 — Classic GoF Decorator Pattern.
 *
 * Structure:
 *  1. TextProcessor        — Component interface
 *  2. BaseTextProcessor    — Concrete component (identity — returns text as-is)
 *  3. TextProcessorDecorator — Abstract decorator (wraps a TextProcessor)
 *  4. TrimDecorator        — Concrete decorator
 *  5. UpperCaseDecorator   — Concrete decorator
 *  6. SanitizeDecorator    — Concrete decorator
 *
 * Key difference vs Pipeline (Question8Correction):
 *  - Each decorator WRAPS the next one (delegation chain, not a list)
 *  - Order is controlled by nesting at construction time
 *  - Adding new behaviour = new decorator class, zero existing code touched (OCP)
 */
public class Question8CorrectionDecorator {

    // 1. Component interface
    interface TextProcessor {
        String process(String text);
    }

    // 2. Concrete component — base, does nothing, entry point of the chain
    static class BaseTextProcessor implements TextProcessor {
        @Override
        public String process(String text) {
            return text;
        }
    }

    // 3. Abstract decorator — wraps any TextProcessor, delegates to it
    static abstract class TextProcessorDecorator implements TextProcessor {
        private final TextProcessor wrapped;

        protected TextProcessorDecorator(TextProcessor wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public String process(String text) {
            return wrapped.process(text);   // delegate first, then concrete decorator adds behaviour
        }
    }

    // 4. Concrete decorators — each adds exactly one transformation

    static class TrimDecorator extends TextProcessorDecorator {
        TrimDecorator(TextProcessor wrapped) { super(wrapped); }

        @Override
        public String process(String text) {
            return super.process(text).trim();
        }
    }

    static class UpperCaseDecorator extends TextProcessorDecorator {
        UpperCaseDecorator(TextProcessor wrapped) { super(wrapped); }

        @Override
        public String process(String text) {
            return super.process(text).toUpperCase();
        }
    }

    static class SanitizeDecorator extends TextProcessorDecorator {
        SanitizeDecorator(TextProcessor wrapped) { super(wrapped); }

        @Override
        public String process(String text) {
            return super.process(text).replaceAll("[^a-zA-Z0-9 ]", "");
        }
    }

    // 5. Caller — build the chain by nesting decorators
    public static void main(String[] args) {

        // Order of execution: trim → uppercase → sanitize
        // Read from innermost to outermost:
        TextProcessor processor = new SanitizeDecorator(
                                    new UpperCaseDecorator(
                                      new TrimDecorator(
                                        new BaseTextProcessor())));

        String result = processor.process("  Hello, World!  ");
        System.out.println("result = " + result); // HELLO WORLD

        // Adding a new behaviour (e.g. replace spaces with underscores)?
        // Just write a new decorator class — nothing else changes.
    }
}
