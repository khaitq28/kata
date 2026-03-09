package refactoring_a;

/**
 * Strategy for determining the tax rate for a product.
 */
@FunctionalInterface
public interface TaxPolicy {
    /**
     * Return the tax rate (e.g. 0.1 for 10%) for the product and customer.
     */
    double getRate(Product product, CustomerType customerType);
}
