package PrimeFactors;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeFactorsTest {

    public static void main(String ...args) {
        PrimeFactors p = new PrimeFactors();
        System.out.println(p.generate(100));
        System.out.println(p.generate(70));
        System.out.println(p.generate(135));
    }

    private final PrimeFactors p = new PrimeFactors();
    @Test
    public void generateTest() {
        assertIterableEquals(p.generate(100), List.of(2,2,5,5));
        assertIterableEquals(p.generate(70), List.of(2,5,7));
        assertIterableEquals(p.generate(135), List.of(3, 3, 3, 5));
    }
}