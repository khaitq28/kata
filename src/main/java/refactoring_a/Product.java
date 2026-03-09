package refactoring_a;

public class Product {

    // Tax rates (applied to base total)
    private static final double TAX_ELECTRONICS = 0.1;
    private static final double TAX_CLOTHING = 0.08;
    private static final double TAX_FOOD = 0.1;
    private static final double TAX_FOOD_VIP = 0.05;
    private static final double TAX_NONE = 0.0;

    // Electronics discount multipliers (price after discount)
    private static final double DISC_ELECTRONICS_PREMIUM = 0.9;
    private static final double DISC_ELECTRONICS_VIP = 0.85;
    private static final double DISC_ELECTRONICS_REGULAR = 0.95;

    // Clothing discount multipliers
    private static final double DISC_CLOTHING_HOLIDAY_PREMIUM = 0.8;
    private static final double DISC_CLOTHING_HOLIDAY_VIP = 0.75;
    private static final double DISC_CLOTHING_HOLIDAY_REGULAR = 0.85;
    private static final double DISC_CLOTHING_PREMIUM = 0.9;
    private static final double DISC_CLOTHING_VIP = 0.85;

    // Food discount multipliers
    private static final double DISC_FOOD_QUANTITY_10_PLUS = 0.9;
    private static final double DISC_FOOD_VIP = 0.95;

    // Loyalty discount multipliers
    private static final double DISC_LOYALTY_1000_VIP = 0.9;
    private static final double DISC_LOYALTY_1000_PREMIUM = 0.95;
    private static final double DISC_LOYALTY_1000_REGULAR = 0.98;
    private static final double DISC_LOYALTY_500_PREMIUM_VIP = 0.97;

    // Bulk quantity discount multipliers
    private static final double DISC_BULK_20 = 0.95;
    private static final double DISC_BULK_10 = 0.97;

    // Quantity and loyalty thresholds
    private static final int BULK_QUANTITY_20 = 20;
    private static final int BULK_QUANTITY_10 = 10;
    private static final int FOOD_QUANTITY_FOR_DISCOUNT = 10;
    private static final int LOYALTY_TIER_1000 = 1000;
    private static final int LOYALTY_TIER_500 = 500;

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

    private double applyElectronicsDiscount(double itemTotal, CustomerType customerType) {
        if (!isElectronics()) {
            return itemTotal;
        }
        if (isPremium(customerType)) {
            return itemTotal * DISC_ELECTRONICS_PREMIUM;
        }
        if (isVip(customerType)) {
            return itemTotal * DISC_ELECTRONICS_VIP;
        }
        return itemTotal * DISC_ELECTRONICS_REGULAR;
    }

    double getTotal(CustomerType customerType, boolean isHolidaySeason, int loyaltyPoints) {

        double itemTotal = getBaseTotal();

        itemTotal = applyElectronicsDiscount(itemTotal, customerType);
        itemTotal = applyClothingDiscount(itemTotal, customerType, isHolidaySeason);
        itemTotal = applyFoodDiscount(itemTotal, customerType);
        itemTotal = applyLoyaltyDiscount(itemTotal, customerType, loyaltyPoints);
        itemTotal = applyBulkDiscount(itemTotal);

        return itemTotal;
    }

    private double applyBulkDiscount(double itemTotal) {
        if (this.quantity >= BULK_QUANTITY_20) {
            return itemTotal * DISC_BULK_20;
        } else if (this.quantity >= BULK_QUANTITY_10) {
            return itemTotal * DISC_BULK_10;
        }
        return itemTotal;
    }

    private double applyLoyaltyDiscount(double itemTotal, CustomerType customerType, int loyaltyPoints) {
        if (loyaltyPoints >= LOYALTY_TIER_1000) {
            if (isVip(customerType)) {
                return itemTotal * DISC_LOYALTY_1000_VIP;
            } else if (isPremium(customerType)) {
                return itemTotal * DISC_LOYALTY_1000_PREMIUM;
            } else {
                return itemTotal * DISC_LOYALTY_1000_REGULAR;
            }
        } else if (loyaltyPoints >= LOYALTY_TIER_500 && (isPremium(customerType) || isVip(customerType))) {
            return itemTotal * DISC_LOYALTY_500_PREMIUM_VIP;
        }
        return itemTotal;
    }

    private double applyFoodDiscount(double itemTotal, CustomerType customerType) {
        if (!isFood()) {
            return itemTotal;
        }
        if (this.quantity >= FOOD_QUANTITY_FOR_DISCOUNT) {
            itemTotal = itemTotal * DISC_FOOD_QUANTITY_10_PLUS;
        }
        if (isVip(customerType)) {
            itemTotal = itemTotal * DISC_FOOD_VIP;
        }
        return itemTotal;
    }

    private double applyClothingDiscount(double itemTotal, CustomerType customerType, boolean isHolidaySeason) {
        if (!isClothing()) {
            return itemTotal;
        }
        if (isHolidaySeason) {
            if (isPremium(customerType)) {
                return itemTotal * DISC_CLOTHING_HOLIDAY_PREMIUM;
            } else if (isVip(customerType)) {
                return itemTotal * DISC_CLOTHING_HOLIDAY_VIP;
            } else {
                return itemTotal * DISC_CLOTHING_HOLIDAY_REGULAR;
            }
        } else {
            if (isPremium(customerType)) {
                return itemTotal * DISC_CLOTHING_PREMIUM;
            } else if (isVip(customerType)) {
                return itemTotal * DISC_CLOTHING_VIP;
            }
        }
        return itemTotal;
    }

    public double getTax(CustomerType customerType) {
        return getBaseTotal() * getTaxRate(customerType);
    }

    private double getTaxRate(CustomerType customerType) {
        if (isElectronics()) {
            return TAX_ELECTRONICS;
        } else if (isClothing()) {
            return TAX_CLOTHING;
        } else if (isFood()) {
            return isVip(customerType) ? TAX_FOOD_VIP : TAX_FOOD;
        }
        return TAX_NONE;
    }

    private boolean isFood() {
        return this.category == Category.FOOD;
    }

    private static boolean isVip(CustomerType customerType) {
        return customerType == CustomerType.VIP;
    }

    private static boolean isPremium(CustomerType customerType) {
        return customerType == CustomerType.PREMIUM;
    }

    private boolean isClothing() {
        return this.category == Category.CLOTHING;
    }

    private boolean isElectronics() {
        return this.category == Category.ELECTRONICS;
    }
}