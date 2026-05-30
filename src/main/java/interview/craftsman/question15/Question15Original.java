package interview.craftsman.question15;

/**
 * INTERVIEW QUESTION 15 — Original (smelly) code.
 *
 * Smells present:
 *  - Data Clump: street / city / zipCode / country always travel together
 *    across every method signature
 *  - Primitive Obsession: raw strings instead of an Address value object
 *  - Any structural change to address (e.g. adding a state field) requires
 *    modifying every method signature — Shotgun Surgery
 *  - Validation logic (non-null, format) would be duplicated in every caller
 */
public class Question15Original {

    static class OrderService {

        public void createOrder(String customerId,
                                String street, String city, String zipCode, String country,
                                double amount) {
            System.out.println("Creating order for " + customerId + " → " + street + ", " + city);
        }

        public void updateShippingAddress(String orderId,
                                          String street, String city, String zipCode, String country) {
            System.out.println("Updating address for order " + orderId);
        }

        public double calculateShippingCost(String street, String city, String zipCode, String country) {
            return country.equals("FR") ? 5.0 : 15.0;
        }

        public boolean isDeliverable(String street, String city, String zipCode, String country) {
            return street != null && city != null && zipCode != null && country != null;
        }
    }
}
