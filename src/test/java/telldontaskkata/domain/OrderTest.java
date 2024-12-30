package telldontaskkata.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private final Order order = new Order();

    @Test
    void isShipped() {
        assertFalse(order.isShipped());
        order.setStatus(OrderStatus.SHIPPED);
        assertTrue(order.isShipped());
    }

    @Test
    void isApproval() {
        assertFalse(order.isApproval());
        order.setStatus(OrderStatus.APPROVED);
        assertTrue(order.isApproval());
    }

    @Test
    void isRejected() {
        assertFalse(order.isRejected());
        order.setStatus(OrderStatus.REJECTED);
        assertTrue(order.isRejected());
    }
}