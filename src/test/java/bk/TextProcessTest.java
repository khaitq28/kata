package bk;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessTest {

    /**
     *      * "Bonjour, bonjour!! Test123 test."
     *      * doit être analysé comme :
     *      * bonjour
     *      * bonjour
     *      * test
     *      * test
     */

    @Test
    void process() {

        List<String> result = TextProcess.process("Bonjour, bonjour!! Test123 test.");

        assertEquals(4, result.size());

        assertEquals("bonjour", result.get(0));
        assertEquals("bonjour", result.get(1));
        assertEquals("test", result.get(2));
        assertEquals("test", result.get(3));
    }

    @Test
    void processOther() {
        List<String> result = TextProcess.process("Bonjour, je suis Laurent. Bonjour Laurent! Test123 test.");
        assertEquals(8, result.size());
        assertEquals("bonjour", result.get(0));
        assertEquals("je", result.get(1));
        assertEquals("suis", result.get(2));
        assertEquals("laurent", result.get(3));

        assertEquals("bonjour", result.get(4));
        assertEquals("laurent", result.get(5));
        assertEquals("test", result.get(6));
        assertEquals("test", result.get(7));
    }

    @Test
    void testFreq() {
        Map<String, Integer> result = TextProcess.fre("Bonjour, je suis Laurent. Bonjour Laurent! Test123 test.");

        int total = result.values().stream().reduce(0, Integer::sum);

        assertEquals(8, total);

    }

}