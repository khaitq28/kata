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
            double itemTotal = p.price * p.quantity;

            // Electronics discount
            if (p.category.equals("Electronics")) {
                if (customerType.equals("Premium")) {
                    itemTotal = itemTotal * 0.9;
                } else if (customerType.equals("VIP")) {
                    itemTotal = itemTotal * 0.85;
                } else {
                    itemTotal = itemTotal * 0.95;
                }
            }

            // Clothing discount
            if (p.category.equals("Clothing")) {
                if (isHolidaySeason) {
                    if (customerType.equals("Premium")) {
                        itemTotal = itemTotal * 0.8;
                    } else if (customerType.equals("VIP")) {
                        itemTotal = itemTotal * 0.75;
                    } else {
                        itemTotal = itemTotal * 0.85;
                    }
                } else {
                    if (customerType.equals("Premium")) {
                        itemTotal = itemTotal * 0.9;
                    } else if (customerType.equals("VIP")) {
                        itemTotal = itemTotal * 0.85;
                    }
                }
            }

            // Food discount
            if (p.category.equals("Food")) {
                if (p.quantity >= 10) {
                    itemTotal = itemTotal * 0.9;
                }
                if (customerType.equals("VIP")) {
                    itemTotal = itemTotal * 0.95;
                }
            }

            // Loyalty points discount
            if (loyaltyPoints >= 1000) {
                if (customerType.equals("VIP")) {
                    itemTotal = itemTotal * 0.9;
                } else if (customerType.equals("Premium")) {
                    itemTotal = itemTotal * 0.95;
                } else {
                    itemTotal = itemTotal * 0.98;
                }
            } else if (loyaltyPoints >= 500) {
                if (customerType.equals("Premium") || customerType.equals("VIP")) {
                    itemTotal = itemTotal * 0.97;
                }
            }

            // Bulk discount
            if (p.quantity >= 20) {
                itemTotal = itemTotal * 0.95;
            } else if (p.quantity >= 10) {
                itemTotal = itemTotal * 0.97;
            }

            total += itemTotal;
        }

        // Tax calculation
        double tax = 0.0;

        for (Product p : products) {
            double itemTotal = p.price * p.quantity;
            if (p.category.equals("Electronics")) {
                tax += itemTotal * 0.1;
            } else if (p.category.equals("Clothing")) {
                tax += itemTotal * 0.08;
            } else if (p.category.equals("Food")) {
                if (customerType.equals("VIP")) {
                    tax += itemTotal * 0.05;
                } else {
                    tax += itemTotal * 0.1;
                }
            }
        }

        return total + tax;
    }
}