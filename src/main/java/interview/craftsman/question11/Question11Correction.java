package interview.craftsman.question11;

/**
 * Correction: business rules live inside the Order entity (Rich Domain Model).
 * The service becomes a thin orchestrator — persistence, notifications, etc.
 */
public class Question11Correction {

    static class OrderService {

        public void ship(Order order) {
            if (!order.canBeShipped())
                throw new IllegalStateException("Order " + order.getId() + " cannot be shipped");
            System.out.println("Shipping order " + order.getId());
        }

        public void applyPromotion(Order order, double percent) {
            order.applyDiscount(percent);
            System.out.println("Discount applied. New amount: " + order.getAmount());
        }

        public void cancel(Order order) {
            order.cancel();
            System.out.println("Order " + order.getId() + " cancelled");
        }
    }
}
