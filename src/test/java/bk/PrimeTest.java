package bk;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @ParameterizedTest
    @ValueSource(ints = {2,3,5,7,11,17,19,41})
    void isPrime(int n) {
        assertTrue(Prime.isPrime(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,6,8,9,10,15,21,33,49,99})
    void isNotPrime(int n) {
        assertFalse(Prime.isPrime(n));
    }

    @ParameterizedTest
    @CsvSource({"10,4", "20,8"})
    void countPrime(int n, int count) {
        assertEquals(count, Prime.countPrime(n));
    }
}