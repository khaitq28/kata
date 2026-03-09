package refactoring_a;

public class FoodDiscountPolicy implements DiscountPolicy {
    private static final int QUANTITY_FOR_DISCOUNT = 10;
    private static final double DISC_QUANTITY_10_PLUS = 0.9;
    private static final double DISC_VIP = 0.95;

    @Override
    public double apply(Product product, double amount, DiscountContext context) {
        if (product.category != Category.FOOD) {
            return amount;
        }
        if (product.quantity >= QUANTITY_FOR_DISCOUNT) {
            amount = amount * DISC_QUANTITY_10_PLUS;
        }
        if (context.getCustomerType() == CustomerType.VIP) {
            amount = amount * DISC_VIP;
        }
        return amount;
    }
}
