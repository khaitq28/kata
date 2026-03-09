package refactoring_a;

public class ShoppingCart {

    public Product[] products;
    public CustomerType customerType;
    public boolean isHolidaySeason;
    public int loyaltyPoints;

    public ShoppingCart(Product[] products, CustomerType customerType,
                        boolean isHolidaySeason, int loyaltyPoints) {
        this.products = products;
        this.customerType = customerType;
        this.isHolidaySeason = isHolidaySeason;
        this.loyaltyPoints = loyaltyPoints;
    }

    public double calculateTotal() {
        double total = 0.0;
        double tax = 0.0;
        for (Product p : products) {
            total += p.getTotal(customerType, isHolidaySeason, loyaltyPoints);
            tax += p.getTax(customerType);
        }
        return total + tax;
    }

}