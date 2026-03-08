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


    private double getBaseTotal() {
        return this.price * this.quantity;
    }

    private double applyElectronicsDiscount(double itemTotal, String customerType){
        if (!isElectronics()) {
            return itemTotal;
        }
        if (isPremium(customerType)) {
            return itemTotal * 0.9;
        }
        if (isVip(customerType)) {
            return itemTotal * 0.85;
        }
        itemTotal = itemTotal * 0.95;
        return itemTotal;
    }

    double getTotal(String customerType, boolean isHolidaySeason, int loyaltyPoints) {

        double itemTotal = getBaseTotal();

        itemTotal = applyElectronicsDiscount(itemTotal, customerType);
        itemTotal = applyClothingDiscount(itemTotal, customerType, isHolidaySeason);
        itemTotal = applyFoodDiscount(itemTotal, customerType);

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

    private double applyFoodDiscount(double itemTotal, String customerType) {
        if (!isFood()) {
            return itemTotal;
        }
        if (this.quantity >= 10) {
            itemTotal = itemTotal * 0.9;
        }
        if (isVip(customerType)) {
            itemTotal = itemTotal * 0.95;
        }
        return itemTotal;
    }

    private double applyClothingDiscount(double itemTotal, String customerType, boolean isHolidaySeason) {
        if (!isClothing()) {
            return itemTotal;
        }
        if (isHolidaySeason) {
            if (isPremium(customerType)) {
                return  itemTotal * 0.8;
            } else if (isVip(customerType)) {
                return itemTotal * 0.75;
            } else {
                return itemTotal * 0.85;
            }
        } else {
            if (isPremium(customerType)) {
                return itemTotal * 0.9;
            } else if (isVip(customerType)) {
                return itemTotal * 0.85;
            }
        }
        return itemTotal;
    }

    public double getTax(String customerType) {
        double itemTotal = getBaseTotal();
        double taxRate = getTaxRate(customerType);
        return itemTotal * taxRate;
    }

    private double getTaxRate(String customerType) {
        if (isElectronics()) {
            return 0.1;
        } else if (isClothing()) {
            return 0.08;
        } else if (isFood()) {
            return isVip(customerType) ? 0.05 : 0.1;
        }
        return 0.0;
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
}