package refactoring_a;

public class ClothingDiscountPolicy implements DiscountPolicy {
    private static final double DISC_HOLIDAY_PREMIUM = 0.8;
    private static final double DISC_HOLIDAY_VIP = 0.75;
    private static final double DISC_HOLIDAY_REGULAR = 0.85;
    private static final double DISC_PREMIUM = 0.9;
    private static final double DISC_VIP = 0.85;

    @Override
    public double apply(Product product, double amount, DiscountContext context) {
        if (product.category != Category.CLOTHING) {
            return amount;
        }
        if (context.isHolidaySeason()) {
            CustomerType t = context.getCustomerType();
            if (t == CustomerType.PREMIUM) return amount * DISC_HOLIDAY_PREMIUM;
            if (t == CustomerType.VIP) return amount * DISC_HOLIDAY_VIP;
            return amount * DISC_HOLIDAY_REGULAR;
        } else {
            CustomerType t = context.getCustomerType();
            if (t == CustomerType.PREMIUM) return amount * DISC_PREMIUM;
            if (t == CustomerType.VIP) return amount * DISC_VIP;
            return amount;
        }
    }
}
