package interview.craftsman.question11;

import java.util.List;

/**
 * INTERVIEW QUESTION 11 — Original (smelly) code.
 *
 * Smells present:
 *  - Anemic Domain Model (DDD anti-pattern): Order is a pure data bag with no behaviour
 *  - Business logic (canShip, applyDiscount, cancel) lives in the service layer
 *  - Service violates SRP: it owns domain rules that belong to the entity
 *  - Tell Don't Ask violation: service inspects entity state and decides, instead of
 *    telling the entity to act
 */
public class Question11Original {

    // ---- pure data bag — no behaviour ----
    static class Order {
        private String id;
        private String status;          // "PENDING", "PAID", "SHIPPED", "CANCELLED"
        private double amount;
        private List<String> items;

        public String getId()              { return id; }
        public String getStatus()          { return status; }
        public void setStatus(String s)    { this.status = s; }
        public double getAmount()          { return amount; }
        public void setAmount(double a)    { this.amount = a; }
        public List<String> getItems()     { return items; }
    }

    // ---- service owns ALL domain rules ----
    static class OrderService {

        public boolean canShip(Order order) {
            return "PAID".equals(order.getStatus()) && !order.getItems().isEmpty();
        }

        public void applyDiscount(Order order, double percent) {
            if (percent < 0 || percent > 100)
                throw new IllegalArgumentException("Invalid discount percentage");
            order.setAmount(order.getAmount() * (1 - percent / 100));
        }

        public void cancelOrder(Order order) {
            if ("SHIPPED".equals(order.getStatus()) || "CANCELLED".equals(order.getStatus()))
                throw new IllegalStateException("Cannot cancel order in status: " + order.getStatus());
            order.setStatus("CANCELLED");
        }
    }
}