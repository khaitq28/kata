package telldontaskkata.useCase;

import lombok.AllArgsConstructor;
import telldontaskkata.repository.OrderRepository;
import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderStatus;

@AllArgsConstructor
public class OrderApprovalUseCase {
    private final OrderRepository orderRepository;

    public void run(OrderApprovalRequest request) {
        final Order order = orderRepository.getById(request.getOrderId()).orElseThrow(OrderNotFoundException::new);
        order.validateToApproval();
        order.setStatus(OrderStatus.APPROVED);
        orderRepository.save(order);
    }

}
