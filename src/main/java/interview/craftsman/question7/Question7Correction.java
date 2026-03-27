package interview.craftsman.question7;


public class Question7Correction {

    private final OrderService orderService;
    private final InventoryService inventoryService;
    private final EmailService emailService;
    private final InvoiceService invoiceService;
    private final AuditService auditService;

    public Question7Correction(OrderService orderService, InventoryService inventoryService, EmailService emailService, InvoiceService invoiceService, AuditService auditService) {
        this.orderService = orderService;
        this.inventoryService = inventoryService;
        this.emailService = emailService;
        this.invoiceService = invoiceService;
        this.auditService = auditService;
    }

    public void createOrder(Order order) {
        // 1. validate payment
        order = this.orderService.create(order);

        // 3. save to database
        order = this.orderService.saveOrder(order);

        // 4. update inventory
        inventoryService.updateInventory(order);

        // 5. send confirmation email
        emailService.sendUserEmail(order.getCustomerEmail());

        // 6. generate invoice PDF
        invoiceService.generateInvoice(order.getId());

        // 7. log audit trail
        auditService.audit(order.getId());
    }

    public static class OrderService {
        public Order create(Order order) {
            if (order.getAmount() <= 0) {
                throw new IllegalArgumentException("Invalid amount");
            }
            return order;
        }

        public Order saveOrder(Order order) {
            System.out.println("Saving order " + order.getId() + " to DB, total=" + order.getTotal());
            return order;
        }
    }

    public static class InventoryService {
        public void updateInventory(Order order) {
            System.out.println("Updating inventory for order " + order.getId());
        }
    }

    public static class EmailService {
        public void sendUserEmail(String  email) {
            System.out.println("Sending email to " + email);
        }
    }

    public static class InvoiceService {
        public void generateInvoice(String orderId) {
            System.out.println("Generating PDF invoice for order " + orderId);
        }
    }

    public static class AuditService {
        public void audit(String orderId) {
            System.out.println("Audit log: order " + orderId + " created");
        }
    }

}
