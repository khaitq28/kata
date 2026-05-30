package interview.craftsman.question15;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
public class Question15Correction {

    @Data
    @Value
    static class Address {
        private String street;
        private String city;
        private String zipCode;
        private String country;

        public boolean isDeliverable() {
            return street != null && city != null && zipCode != null && country != null;
        }
        public boolean isFrance() {
            return StringUtils.equalsIgnoreCase(country, "FR");
        }

        public String getShortenAddress() {
            return getStreet() + ", " + getCity();
        }
    }

    @Data
    @Builder
    static class Order {
        private String id;
        private String customerId;
        private Address shippingAddress;
        private BigDecimal amount;
    }

    static class OrderService {

        private final List<Order> orders = new ArrayList<>();

        public void createOrder(String customerId, Address address, BigDecimal amount) {
            Order order = Order.builder().customerId(customerId).shippingAddress(address).amount(amount).build();
            orders.add(order);
            System.out.println("Creating order for " + customerId + " → " + address.getShortenAddress());
        }

        public void updateShippingAddress(String orderId, Address address) {
            Order order = orders.stream().filter(o -> o.getId().equals(orderId)).findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Order not found: " + orderId));
            order.setShippingAddress(address);
            System.out.println("Updating address for order " + orderId);
        }

        public double calculateShippingCost(Address address) {
            return address.isFrance() ? 5.0 : 15.0;
        }

    }
}
