package refactoring_a;

public class LoyaltyDiscountPolicy implements DiscountPolicy {
    private static final int TIER_1000 = 1000;
    private static final int TIER_500 = 500;
    private static final double DISC_1000_VIP = 0.9;
    private static final double DISC_1000_PREMIUM = 0.95;
    private static final double DISC_1000_REGULAR = 0.98;
    private static final double DISC_500_PREMIUM_VIP = 0.97;

    @Override
    public double apply(Product product, double amount, DiscountContext context) {
        int points = context.getLoyaltyPoints();
        CustomerType t = context.getCustomerType();
        if (points >= TIER_1000) {
            if (t == CustomerType.VIP) return amount * DISC_1000_VIP;
            if (t == CustomerType.PREMIUM) return amount * DISC_1000_PREMIUM;
            return amount * DISC_1000_REGULAR;
        }
        if (points >= TIER_500 && (t == CustomerType.PREMIUM || t == CustomerType.VIP)) {
            return amount * DISC_500_PREMIUM_VIP;
        }
        return amount;
    }
}
