package refactoring_a;

public class Product {
    public String name;
    public String category;
    public double price;
    public int quantity;

    public Product(String name, String category, double price, int quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + ", " + category + ", " + price + ", " + quantity;
    }


    double getTotal(String customerType, boolean isHolidaySeason, int loyaltyPoints) {
        double itemTotal = this.price * this.quantity;

        // Electronics discount
        if (isElectronics()) {
            if (isPremium(customerType)) {
                itemTotal = itemTotal * 0.9;
            } else if (isVip(customerType)) {
                itemTotal = itemTotal * 0.85;
            } else {
                itemTotal = itemTotal * 0.95;
            }
        }

        // Clothing discount
        if (isClothing()) {
            if (isHolidaySeason) {
                if (isPremium(customerType)) {
                    itemTotal = itemTotal * 0.8;
                } else if (isVip(customerType)) {
                    itemTotal = itemTotal * 0.75;
                } else {
                    itemTotal = itemTotal * 0.85;
                }
            } else {
                if (isPremium(customerType)) {
                    itemTotal = itemTotal * 0.9;
                } else if (isVip(customerType)) {
                    itemTotal = itemTotal * 0.85;
                }
            }
        }

        // Food discount
        if (isFood()) {
            if (this.quantity >= 10) {
                itemTotal = itemTotal * 0.9;
            }
            if (isVip(customerType)) {
                itemTotal = itemTotal * 0.95;
            }
        }

        // Loyalty points discount
        if (loyaltyPoints >= 1000) {
            if (isVip(customerType)) {
                itemTotal = itemTotal * 0.9;
            } else if (isPremium(customerType)) {
                itemTotal = itemTotal * 0.95;
            } else {
                itemTotal = itemTotal * 0.98;
            }
        } else if (loyaltyPoints >= 500) {
            if (isPremium(customerType) || isVip(customerType)) {
                itemTotal = itemTotal * 0.97;
            }
        }

        // Bulk discount
        if (this.quantity >= 20) {
            itemTotal = itemTotal * 0.95;
        } else if (this.quantity >= 10) {
            itemTotal = itemTotal * 0.97;
        }

        return itemTotal;
    }

    private boolean isFood() {
        return this.category.equals("Food");
    }


    private static boolean isVip(String customerType) {
        return customerType.equals("VIP");
    }

    private static boolean isPremium(String customerType) {
        return customerType.equals("Premium");
    }

    private boolean isClothing() {
        return this.category.equals("Clothing");
    }

    private boolean isElectronics() {
        return this.category.equals("Electronics");
    }

    public double getTax(String customerType) {
        double tax = 0.0;
        double itemTotal = this.price * this.quantity;
        if (isElectronics()) {
            tax += itemTotal * 0.1;
        } else if (isClothing()) {
            tax += itemTotal * 0.08;
        } else if (isFood()) {
            if (isVip(customerType)) {
                tax += itemTotal * 0.05;
            } else {
                tax += itemTotal * 0.1;
            }
        }
        return tax;
    }
}