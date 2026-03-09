package refactoring_a;

import java.util.Arrays;
import java.util.List;

public class Product {

    private static final List<DiscountPolicy> DEFAULT_DISCOUNT_POLICIES = Arrays.asList(
            new ElectronicsDiscountPolicy(),
            new ClothingDiscountPolicy(),
            new FoodDiscountPolicy(),
            new LoyaltyDiscountPolicy(),
            new BulkDiscountPolicy()
    );
    
    private static final TaxPolicy DEFAULT_TAX_POLICY = new DefaultTaxPolicy();

    public String name;
    public Category category;
    public double price;
    public int quantity;

    public Product(String name, Category category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ", " + category.getDisplayName() + ", " + price + ", " + quantity;
    }

    private double getBaseTotal() {
        return this.price * this.quantity;
    }

    /**
     * Returns the line total after all discounts, using the given context.
     */
    public double getTotal(DiscountContext context) {
        double amount = getBaseTotal();
        for (DiscountPolicy policy : DEFAULT_DISCOUNT_POLICIES) {
            amount = policy.apply(this, amount, context);
        }
        return amount;
    }

    /**
     * Returns the tax amount for this line, using the customer type from the context.
     */
    public double getTax(DiscountContext context) {
        return getBaseTotal() * DEFAULT_TAX_POLICY.getRate(this, context.getCustomerType());
    }
}
