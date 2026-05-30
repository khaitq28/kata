package interview.craftsman.question14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * INTERVIEW QUESTION 14 — Original (smelly) code.
 *
 * Smells present:
 *  - CQS violation: addItem() modifies state AND returns the new total
 *  - CQS violation: removeItem() mutates the list AND returns the remaining items
 *  - CQS violation: checkout() clears the cart AND returns a confirmation code
 *  - Commands should have no return value; queries should have no side effects
 *  - Mixed intent makes methods hard to test, compose, and reason about
 */
public class Question14Original {

    static class Cart {

        private final List<String> items = new ArrayList<>();
        private double total = 0;

        // command + query mixed: modifies state AND returns new total
        public double addItem(String item, double price) {
            items.add(item);
            total += price;
            return total;
        }

        // command + query mixed: removes item AND returns remaining list
        public List<String> removeItem(String item, double price) {
            items.remove(item);
            total -= price;
            return Collections.unmodifiableList(items);
        }

        // command + query mixed: clears cart AND returns confirmation code
        public String checkout() {
            if (items.isEmpty()) throw new IllegalStateException("Cart is empty");
            items.clear();
            total = 0;
            return "CONF-" + System.currentTimeMillis();
        }
    }
}
