package interview.craftsman.question16.correction;

import interview.craftsman.question16.*;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class CorrectedOrderService {

    private final InventoryServiceInterface inventoryService;
    private final AuditServiceInterface auditService;
    private final NotificationService notificationService;

    public void placeOrder(Order order) {
        System.out.println("Saving order " + order.getId());
        notificationService.sendNotification(order);
        inventoryService.reserve(order.getItems());
        auditService.log("Order placed: " + order.getId());
    }
}
