package movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StringBuilder statement = new StringBuilder("Rental Record for " + getName() + "\n");
        for (Rental rental : rentals) {
            statement.append(rental.statement());
        }
        statement.append("Amount owed is ").append(getTotalAmount()).append("\n");
        statement.append("You earned ").append(getFrequentRenterPoint()).append(" frequent renter points");

        return statement.toString();
    }

    private double getTotalAmount() {
        double ret = 0.0d;
        for (Rental rental: rentals)
            ret+= rental.getAmount();
        return ret;
    }

    private int getFrequentRenterPoint() {
        int ret = 0;
        for (Rental rental: rentals) {
            ret += rental.getFrequentRenterPoints();
        }
        return ret;
    }

}
