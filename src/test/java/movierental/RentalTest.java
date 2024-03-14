package movierental;

import movierental.price.NewReleasePrice;
import movierental.price.RegularPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RentalTest {

    private Rental rental;


    @Test
    void getFrequentRenterPoints() {
        rental = new Rental(new Movie("abc", new NewReleasePrice()), 3);
        assertEquals(2, rental.getFrequentRenterPoints());

        rental = new Rental(new Movie("abc", new RegularPrice()), 3);
        assertEquals(1, rental.getFrequentRenterPoints());

    }
}