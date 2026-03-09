package refactoring_a;

/**
 * Strategy for applying a single discount step to a product line total.
 */
@FunctionalInterface
public interface DiscountPolicy {
    /**
     * Apply this discount to the given amount for the product in context.
     *
     * @param product the product
     * @param amount  current line total (after previous discounts)
     * @param context discount context (customer, holiday, loyalty)
     * @return new amount after this discount (may be unchanged)
     */
    double apply(Product product, double amount, DiscountContext context);
}
