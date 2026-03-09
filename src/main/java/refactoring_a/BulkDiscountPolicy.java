package refactoring_a;

public class BulkDiscountPolicy implements DiscountPolicy {
    private static final int BULK_20 = 20;
    private static final int BULK_10 = 10;
    private static final double DISC_20 = 0.95;
    private static final double DISC_10 = 0.97;

    @Override
    public double apply(Product product, double amount, DiscountContext context) {
        if (product.quantity >= BULK_20) return amount * DISC_20;
        if (product.quantity >= BULK_10) return amount * DISC_10;
        return amount;
    }
}
