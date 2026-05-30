package interview.craftsman.question16.correction;

public class EmailServiceHandler implements OrderNotificationHandler{

    @Override
    public void handleNotification(Order order) {
        System.out.println("Email sent to " + order.getCustomerEmail());
    }
}
