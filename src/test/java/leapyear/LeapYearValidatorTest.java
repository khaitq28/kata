package leapyear;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LeapYearValidatorTest {

    private final LeapYearValidator validator = new LeapYearValidator();
    @Test
    void isLeapYear1() {
        for(int i = 0; i < 10; i++) {
            assertTrue(validator.isLeapYear(400 * i));
            assertFalse(validator.isLeapYear(400 * i + 1));
        }
    }

    @Test
    void isLeapYear2() {
        assertTrue(validator.isLeapYear(2008));
        assertTrue(validator.isLeapYear(2012));
        assertTrue(validator.isLeapYear(2016));
        assertTrue(validator.isLeapYear(2020));
    }

    @Test
    void isLeapYear3() {
        assertFalse(validator.isLeapYear(2100));
        assertFalse(validator.isLeapYear(4200));
        assertFalse(validator.isLeapYear(1100));
        assertFalse(validator.isLeapYear(900));
    }

    @Test
    void isLeapYear4() {
        assertFalse(validator.isLeapYear(2017));
        assertFalse(validator.isLeapYear(2018));
        assertFalse(validator.isLeapYear(2019));
    }

    @ParameterizedTest
    @CsvSource({
            "4, true",
            "100, false",
            "400, true",
            "1900, false",
            "2000, true",
            "2019, false",
            "2020, true"
    })
    void testParameterizedLeapYear(int year, boolean expected) {
        assertEquals(expected, validator.isLeapYear(year));
    }

    @Property(tries = 300)
    void testLeapYear(@ForAll("validYears") int year) {
        boolean expected = (year > 0 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)));
        assertEquals(expected, validator.isLeapYear(year));
    }

    @Provide
    Arbitrary<Integer> validYears() {
        return Arbitraries.integers().between(1, 10000);
    }
}
