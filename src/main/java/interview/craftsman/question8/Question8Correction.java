package interview.craftsman.question8;

import java.util.ArrayList;
import java.util.List;

public class Question8Correction {

    public static void main(String[] args) {
        TextProcessor textProcessor = new TextProcessor()
                .addProcessor(new TrimTextProcessor())
                .addProcessor(new UpperCaseProcessor())
                .addProcessor(new SanitizedProcessor());

        String result = textProcessor.process("  Hello, World!  "); // Output: "HELLO WORLD"
        System.out.println("result = " + result);
    }

    static class TextProcessor {
        private final List<Processor> processors = new ArrayList<>();
        public TextProcessor addProcessor(Processor processor) {
            processors.add(processor);
            return this;
        }
        public String process(String text) {
            for (Processor processor : processors) {
                text = processor.process(text);
            }
            return text;
        }
    }

    interface Processor {
        String process(String text);
    }

    // need trim → extend base
    static class TrimTextProcessor implements Processor {
        @Override
        public String process(String text) {
            return text.trim();
        }
    }

    static class UpperCaseProcessor    implements Processor {
        @Override
        public String process(String text) {
            return text.toUpperCase();
        }
    }

    static class SanitizedProcessor implements Processor  {
        @Override
        public String process(String text) {
            return text.replaceAll("[^a-zA-Z0-9 ]", "");
        }
    }
}
