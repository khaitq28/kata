package interview.craftsman.question11;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private String id;
    private OrderStatus status;
    private double amount;
    private List<String> items;

    public boolean canBeShipped() {
        return OrderStatus.PAID.equals(status) && !items.isEmpty();
    }

    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100)
            throw new IllegalArgumentException("Invalid discount percentage");
        this.amount = this.amount * (1 - percent / 100);
    }

    public void cancel() {
        if (!canBeCanceled())
            throw new IllegalStateException("Cannot cancel order in status: " + getStatus());
        this.status = OrderStatus.CANCELLED;
    }

    private boolean canBeCanceled() {
        return !OrderStatus.SHIPPED.equals(status) &&
                !OrderStatus.CANCELLED.equals(status);
    }
}
