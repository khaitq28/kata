package telldontaskkata.domain;

import lombok.Getter;
import lombok.Setter;
import telldontaskkata.useCase.ApprovedOrderCannotBeRejectedException;
import telldontaskkata.useCase.RejectedOrderCannotBeApprovedException;
import telldontaskkata.useCase.ShippedOrdersCannotBeChangedException;

import java.math.BigDecimal;
import java.util.List;


@Setter
@Getter
public class Order {
    private BigDecimal total;
    private String currency;
    private List<OrderItem> items;
    private BigDecimal tax;
    private OrderStatus status;
    private int id;

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
