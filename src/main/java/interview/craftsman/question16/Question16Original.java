package interview.craftsman.question16;

/**
 * INTERVIEW QUESTION 16 — Original (smelly) code.
 *
 * Smells present:
 *  - Tight coupling: OrderService directly instantiates and calls EmailService,
 *    SmsService, InventoryService, AuditService
 *  - Violates OCP: adding a new side effect (e.g. PushNotificationService) requires
 *    modifying OrderService
 *  - Violates SRP: orchestrating downstream notifications is not OrderService's concern
 *  - Untestable: OrderService cannot be unit-tested without all downstream services
 *  - ???
 */
public class Question16Original {

    static class OrderService {

        private final EmailService emailService = new EmailService();
        private final SmsService smsService = new SmsService();
        private final InventoryService inventoryService = new InventoryService();
        private final AuditService auditService = new AuditService();

        public void placeOrder(Order order) {
            System.out.println("Saving order " + order.getId());

            emailService.sendConfirmation(order.getCustomerEmail());
            smsService.sendAlert(order.getCustomerPhone());
            inventoryService.reserve(order.getItems());
            auditService.log("Order placed: " + order.getId());
        }
    }
}
