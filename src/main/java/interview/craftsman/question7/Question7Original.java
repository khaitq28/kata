package interview.craftsman.question7;

import java.util.List;

/**
 * INTERVIEW QUESTION 7 — Original (smelly) code.
 */
public class Question7Original {

    public void createOrder(Order order) {
        // 1. validate payment
        if (order.getAmount() <= 0) {
            throw new IllegalArgumentException("Invalid amount");
        }

        // 2. calculate tax
        double tax = 0;
        if (order.getCountry().equals("US")) tax = order.getAmount() * 0.08;
        else if (order.getCountry().equals("FR")) tax = order.getAmount() * 0.20;
        double total = order.getAmount() + tax;

        // 3. save to database
        System.out.println("Saving order " + order.getId() + " to DB, total=" + total);

        // 4. update inventory
        System.out.println("Updating inventory for order " + order.getId());

        // 5. send confirmation email
        System.out.println("Sending email to " + order.getCustomerEmail());

        // 6. generate invoice PDF
        System.out.println("Generating PDF invoice for order " + order.getId());

        // 7. log audit trail
        System.out.println("Audit log: order " + order.getId() + " created");
    }

    public List<Order> getAllOrders() {
        // query database
        return List.of();
    }

    public void cancelOrder(String orderId) {
        // cancel logic + email + log
        System.out.println("Cancelling order " + orderId);
        System.out.println("Sending cancellation email");
        System.out.println("Audit log: order " + orderId + " cancelled");
    }
}
