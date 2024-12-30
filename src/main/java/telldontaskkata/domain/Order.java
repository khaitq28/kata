package telldontaskkata.domain;

import lombok.Getter;
import lombok.Setter;
import telldontaskkata.domain.state.OrderState;
import telldontaskkata.useCase.ApprovedOrderCannotBeRejectedException;
import telldontaskkata.useCase.RejectedOrderCannotBeApprovedException;
import telldontaskkata.useCase.ShippedOrdersCannotBeChangedException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


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

}
