package interview.craftsman.question16.correction;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final List<OrderNotificationHandler> handlers;

    @Override
    public void sendNotification(Order order) {
        handlers.forEach(e -> e.handleNotification(order));
    }
}
