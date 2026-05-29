package interview.craftsman.question12;

import java.util.List;

/**
 * INTERVIEW QUESTION 12 — Original (smelly) code.
 *
 * Smells present:
 *  - Feature Envy: InvoiceService is more interested in Customer and Address data
 *    than in its own responsibilities
 *  - Law of Demeter violated: deep chaining customer.getAddress().getCity() etc.
 *  - Domain knowledge (full name, formatted address, order total) leaks into the service
 *  - Tell Don't Ask: service asks for raw state and computes instead of asking objects to act
 */
public class Question12Original {

    static class Address {
        private String street;
        private String city;
        private String zipCode;

        public String getStreet()  { return street; }
        public String getCity()    { return city; }
        public String getZipCode() { return zipCode; }
    }

    static class CustomerOrder {
        private double total;
        public double getTotal() { return total; }
    }

    static class Customer {
        private String firstName;
        private String lastName;
        private Address address;
        private List<CustomerOrder> orders;

        public String getFirstName()          { return firstName; }
        public String getLastName()           { return lastName; }
        public Address getAddress()           { return address; }
        public List<CustomerOrder> getOrders() { return orders; }
    }

    // ---- Feature Envy: this method belongs mostly on Customer / Address ----
    static class InvoiceService {

        public String generateSummary(Customer customer) {
            String fullName = customer.getFirstName() + " " + customer.getLastName();

            String formattedAddress = customer.getAddress().getStreet() + ", "
                    + customer.getAddress().getCity() + " "
                    + customer.getAddress().getZipCode();

            double orderTotal = customer.getOrders().stream()
                    .mapToDouble(CustomerOrder::getTotal)
                    .sum();

            return "Invoice for " + fullName
                    + " | Address: " + formattedAddress
                    + " | Total orders: " + orderTotal;
        }
    }
}
