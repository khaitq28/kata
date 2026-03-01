package refactoring_a;

public class ShoppingCart {

    public Product[] products;
    public String customerType;
    public boolean isHolidaySeason;
    public int loyaltyPoints;

    public ShoppingCart(Product[] products, String customerType,
                        boolean isHolidaySeason, int loyaltyPoints) {
        this.products = products;
        this.customerType = customerType;
        this.isHolidaySeason = isHolidaySeason;
        this.loyaltyPoints = loyaltyPoints;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product p : products) {
            total += p.getTotal(customerType, isHolidaySeason, loyaltyPoints);
        }
        // Tax calculation
        double tax = 0.0;
        for (Product p : products) {
            tax += p.getTax(customerType);
        }
        return total + tax;
    }

}