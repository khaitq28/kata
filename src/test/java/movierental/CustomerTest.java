package movierental;

import movierental.price.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void test() {

        Customer customer = new Customer("Bob");
        customer.addRental(new Rental(new Movie("Jaws", new RegularPrice()), 2));
        customer.addRental(new Rental(new Movie("Golden Eye", new RegularPrice()), 3));
        customer.addRental(new Rental(new Movie("Short New",new NewReleasePrice()), 1));
        customer.addRental(new Rental(new Movie("Long New", new NewReleasePrice()), 2));
        customer.addRental(new Rental(new Movie("Bambi", new ChildrenPrice()), 3));
        customer.addRental(new Rental(new Movie("Toy Story", new ChildrenPrice()), 4));

        String expected = "" +
                "Rental Record for Bob\n" +
                "\tJaws\t2.0\n" +
                "\tGolden Eye\t3.5\n" +
                "\tShort New\t3.0\n" +
                "\tLong New\t6.0\n" +
                "\tBambi\t1.5\n" +
                "\tToy Story\t3.0\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter points";

        assertEquals(expected, customer.statement());
    }

}