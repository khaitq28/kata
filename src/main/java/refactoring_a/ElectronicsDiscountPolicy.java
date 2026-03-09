package refactoring_a;

public class ElectronicsDiscountPolicy implements DiscountPolicy {
    private static final double DISC_PREMIUM = 0.9;
    private static final double DISC_VIP = 0.85;
    private static final double DISC_REGULAR = 0.95;

    @Override
    public double apply(Product product, double amount, DiscountContext context) {
        if (product.category != Category.ELECTRONICS) {
            return amount;
        }
        CustomerType t = context.getCustomerType();
        if (t == CustomerType.PREMIUM) return amount * DISC_PREMIUM;
        if (t == CustomerType.VIP) return amount * DISC_VIP;
        return amount * DISC_REGULAR;
    }
}
