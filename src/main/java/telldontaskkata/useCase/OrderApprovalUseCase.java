package telldontaskkata.useCase;

import lombok.AllArgsConstructor;
import telldontaskkata.repository.OrderRepository;
import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderStatus;

@AllArgsConstructor
public class OrderApprovalUseCase {
    private final OrderRepository orderRepository;

    public void run(OrderApprovalRequest request) {

        final Order order = orderRepository.getById(request.getOrderId());

        if (order.isShipped()) {
            throw new ShippedOrdersCannotBeChangedException();
        }

        if (request.isApproved() && order.isRejected()) {
            throw new RejectedOrderCannotBeApprovedException();
        }

        if (!request.isApproved() && order.isApproval()) {
            throw new ApprovedOrderCannotBeRejectedException();
        }

        order.setStatus(request.isApproved() ? OrderStatus.APPROVED : OrderStatus.REJECTED);
        orderRepository.save(order);
    }
}
