package telldontaskkata.useCase;

import org.junit.jupiter.api.Test;
import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderStatus;
import telldontaskkata.doubles.TestOrderRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderRejectUseCaseTest {
    private final TestOrderRepository orderRepository = new TestOrderRepository();
    private final OrderRejectUseCase useCase = new OrderRejectUseCase(orderRepository);

    @Test
    void rejectedExistingOrder() {
        Order initialOrder = new Order();
        initialOrder.setId(1);
        orderRepository.addOrder(initialOrder);

        OrderRejectRequest request = new OrderRejectRequest(1);
        useCase.run(request);

        final Order savedOrder = orderRepository.getSavedOrder();
        assertThat(savedOrder.getStatus()).isEqualTo(OrderStatus.REJECTED);
    }


    @Test
    void cannotRejectApprovedOrder() {
        Order initialOrder = new Order();
        initialOrder.setStatus(OrderStatus.APPROVED);
        initialOrder.setId(1);
        orderRepository.addOrder(initialOrder);

        OrderRejectRequest request = new OrderRejectRequest(1);

        assertThatThrownBy(() -> useCase.run(request)).isExactlyInstanceOf(ApprovedOrderCannotBeRejectedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }


    @Test
    void shippedOrdersCannotBeRejected() {
        Order initialOrder = new Order();
        initialOrder.setStatus(OrderStatus.SHIPPED);
        initialOrder.setId(1);
        orderRepository.addOrder(initialOrder);

        OrderRejectRequest request = new OrderRejectRequest(1);

        assertThatThrownBy(() -> useCase.run(request))
                .isExactlyInstanceOf(ShippedOrdersCannotBeChangedException.class);
        assertThat(orderRepository.getSavedOrder()).isNull();
    }
}
