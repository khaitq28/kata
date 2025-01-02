package telldontaskkata.useCase;

import lombok.AllArgsConstructor;
import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderStatus;
import telldontaskkata.repository.OrderRepository;

@AllArgsConstructor
public class OrderRejectUseCase {

    private final OrderRepository orderRepository;
    public void run(OrderRejectRequest request) {
        final Order order = orderRepository.getById(request.getOrderId()).orElseThrow(OrderNotFoundException::new);

        if (order.isShipped()) {
            throw new ShippedOrdersCannotBeChangedException();
        }
        if (order.isApproval()) {
            throw new ApprovedOrderCannotBeRejectedException();
        }
        order.setStatus(OrderStatus.REJECTED);
        orderRepository.save(order);
    }
}