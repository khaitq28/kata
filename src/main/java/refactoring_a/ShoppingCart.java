package refactoring_a;

public class ShoppingCart {

    public Product[] products;
    public DiscountContext context;

    public ShoppingCart(Product[] products, DiscountContext context) {
        this.products = products;
        this.context = context;
    }

    public double calculateTotal() {
        double total = 0.0;
        double tax = 0.0;
        for (Product p : products) {
            total += p.getTotal(context);
            tax += p.getTax(context);
        }
        return total + tax;
    }
}