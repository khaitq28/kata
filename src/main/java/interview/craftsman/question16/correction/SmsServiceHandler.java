package interview.craftsman.question16.correction;

public class SmsServiceHandler implements OrderNotificationHandler {

    @Override
    public void handleNotification(Order order) {
        System.out.println("SMS sent to " + order.getCustomerPhone());
    }
}
