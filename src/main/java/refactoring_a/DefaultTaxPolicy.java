package refactoring_a;

public class DefaultTaxPolicy implements TaxPolicy {
    private static final double TAX_ELECTRONICS = 0.1;
    private static final double TAX_CLOTHING = 0.08;
    private static final double TAX_FOOD = 0.1;
    private static final double TAX_FOOD_VIP = 0.05;
    private static final double TAX_NONE = 0.0;

    @Override
    public double getRate(Product product, CustomerType customerType) {
        if (product.category == Category.ELECTRONICS) return TAX_ELECTRONICS;
        if (product.category == Category.CLOTHING) return TAX_CLOTHING;
        if (product.category == Category.FOOD) {
            return customerType == CustomerType.VIP ? TAX_FOOD_VIP : TAX_FOOD;
        }
        return TAX_NONE;
    }
}
