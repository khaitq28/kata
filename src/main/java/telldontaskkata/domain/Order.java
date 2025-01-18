package telldontaskkata.domain;

import lombok.Getter;
import lombok.Setter;
import telldontaskkata.useCase.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static telldontaskkata.domain.OrderStatus.*;


@Setter
@Getter
public class Order {
    private final List<OrderItem> items = new ArrayList<>();

    private String currency;
    private BigDecimal tax = new BigDecimal("0.00");
    private BigDecimal total = new BigDecimal("0.00");

    private OrderStatus status;

    private int id;

    public Order() {
        this.status = OrderStatus.CREATED;
    }
    public void addOrderItem(OrderItem orderItem) {
        this.items.add(orderItem);
        this.total = getTotal().add(orderItem.getTaxedAmount());
        this.tax = getTax().add(orderItem.getTax());
    }

    public boolean isShipped() {
        return this.status.equals(OrderStatus.SHIPPED);
    }
    public boolean isApproval() {
        return this.status.equals(OrderStatus.APPROVED);
    }
    public boolean isRejected() {
        return this.status.equals(OrderStatus.REJECTED);
    }

    public void validateToApproval() {
        if (isShipped()) {
            throw new ShippedOrdersCannotBeChangedException();
        }
        if (isRejected()) {
            throw new RejectedOrderCannotBeApprovedException();
        }
    }

    public void validateToReject() {
        if (isShipped()) {
            throw new ShippedOrdersCannotBeChangedException();
        }
        if (isApproval()) {
            throw new ApprovedOrderCannotBeRejectedException();
        }
    }

    public void validateToShip() {
        if (getStatus().equals(CREATED) || getStatus().equals(REJECTED)) {
            throw new OrderCannotBeShippedException();
        }
        if (getStatus().equals(SHIPPED)) {
            throw new OrderCannotBeShippedTwiceException();
        }
    }
}
