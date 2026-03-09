package refactoring_a;

/**
 * Context for applying discounts: customer type, holiday season, and loyalty points.
 */
public class DiscountContext {
    private final CustomerType customerType;
    private final boolean isHolidaySeason;
    private final int loyaltyPoints;

    public DiscountContext(CustomerType customerType, boolean isHolidaySeason, int loyaltyPoints) {
        this.customerType = customerType;
        this.isHolidaySeason = isHolidaySeason;
        this.loyaltyPoints = loyaltyPoints;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public boolean isHolidaySeason() {
        return isHolidaySeason;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }
}
