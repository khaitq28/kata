package refactoring_a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Product.getTotal and Product.getTax.
 * Same package so we can call package-private getTotal.
 */
class ProductTest {

    private static final double DELTA = 0.001;

    // --- getTotal: Electronics ---
    @Test
    void electronics_regular_noOtherDiscounts() {
        Product p = new Product("Laptop", Category.ELECTRONICS, 1000, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        assertEquals(950, total, DELTA); // 5% discount
    }

    @Test
    void electronics_premium_noOtherDiscounts() {
        Product p = new Product("Laptop", Category.ELECTRONICS, 1000, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 0);
        assertEquals(900, total, DELTA); // 10% discount
    }

    @Test
    void electronics_vip_noOtherDiscounts() {
        Product p = new Product("Laptop", Category.ELECTRONICS, 1000, 1);
        double total = p.getTotal(CustomerType.VIP, false, 0);
        assertEquals(850, total, DELTA); // 15% discount
    }

    // --- getTotal: Clothing ---
    @Test
    void clothing_regular_holiday() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, true, 0);
        assertEquals(85, total, DELTA); // holiday regular 15% off
    }

    @Test
    void clothing_premium_holiday() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, true, 0);
        assertEquals(80, total, DELTA); // 20% off
    }

    @Test
    void clothing_vip_holiday() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.VIP, true, 0);
        assertEquals(75, total, DELTA); // 25% off
    }

    @Test
    void clothing_premium_notHoliday() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 0);
        assertEquals(90, total, DELTA); // 10% off
    }

    @Test
    void clothing_regular_notHoliday_noDiscount() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        assertEquals(100, total, DELTA);
    }

    // --- getTotal: Food ---
    @Test
    void food_quantityUnder10_regular() {
        Product p = new Product("Apple", Category.FOOD, 10, 5);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        assertEquals(50, total, DELTA); // no food discount
    }

    @Test
    void food_quantity10OrMore_regular_bulkApplies() {
        Product p = new Product("Apple", Category.FOOD, 10, 10);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        // base 100, food 10+ → 90, bulk 10 → 90*0.97 = 87.3
        assertEquals(87.3, total, DELTA);
    }

    @Test
    void food_vip_quantity10() {
        Product p = new Product("Apple", Category.FOOD, 50, 10);
        double total = p.getTotal(CustomerType.VIP, false, 0);
        // base 500, food 10+ → 450, VIP → 427.5, bulk 10 → 427.5*0.97 = 414.675
        assertEquals(414.675, total, DELTA);
    }

    // --- getTotal: Loyalty ---
    // 1000+ points: VIP 10%, Premium 5%, Regular 2%
    @Test
    void loyalty1000_vip() {
        Product p = new Product("Laptop", Category.ELECTRONICS, 1000, 1);
        double total = p.getTotal(CustomerType.VIP, false, 1000);
        // base 1000, electronics VIP → 850, loyalty 1000 VIP → 850*0.9 = 765
        assertEquals(765, total, DELTA);
    }

    @Test
    void loyalty1000_premium() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 1000);
        // base 100, no category discount, loyalty 1000+ Premium → 100*0.95 = 95
        assertEquals(95, total, DELTA);
    }

    @Test
    void loyalty1000_regular() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 1000);
        // base 100, loyalty 1000+ Regular → 100*0.98 = 98
        assertEquals(98, total, DELTA);
    }

    // 500-999 points: Premium or VIP 3%, Regular no loyalty discount
    @Test
    void loyalty500_premium() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 500);
        // base 100, clothing premium no holiday → 90, loyalty 500 Premium → 90*0.97 = 87.3
        assertEquals(87.3, total, DELTA);
    }

    @Test
    void loyalty500_vip() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.VIP, false, 500);
        // base 100, loyalty 500-999 VIP → 100*0.97 = 97
        assertEquals(97, total, DELTA);
    }

    @Test
    void loyalty500_regular_noDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 500);
        // base 100, 500-999 Regular gets no loyalty discount
        assertEquals(100, total, DELTA);
    }

    @Test
    void loyalty999_premium_getsDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 999);
        assertEquals(97, total, DELTA); // 500-999 tier: 100*0.97
    }

    @Test
    void loyalty999_regular_noDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 999);
        assertEquals(100, total, DELTA);
    }

    // Below 500: no loyalty discount for any customer type
    @Test
    void loyalty499_vip_noDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.VIP, false, 499);
        assertEquals(100, total, DELTA);
    }

    @Test
    void loyalty499_premium_noDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.PREMIUM, false, 499);
        assertEquals(100, total, DELTA);
    }

    @Test
    void loyalty0_noDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.VIP, false, 0);
        assertEquals(100, total, DELTA);
    }

    // Boundary: exactly 500 enters 500-999 tier
    @Test
    void loyaltyExactly500_vip_getsDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.VIP, false, 500);
        assertEquals(97, total, DELTA);
    }

    // Boundary: exactly 1000 enters 1000+ tier
    @Test
    void loyaltyExactly1000_regular_getsDiscount() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        double total = p.getTotal(CustomerType.REGULAR, false, 1000);
        assertEquals(98, total, DELTA);
    }

    // --- getTotal: Bulk only (category with no category discount) ---
    @Test
    void bulk20_quantityDiscount() {
        Product p = new Product("Widget", Category.OTHER, 10, 20);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        // base 200, bulk 20+ → 190
        assertEquals(190, total, DELTA);
    }

    @Test
    void bulk10_quantityDiscount() {
        Product p = new Product("Widget", Category.OTHER, 10, 10);
        double total = p.getTotal(CustomerType.REGULAR, false, 0);
        // base 100, bulk 10 → 97
        assertEquals(97, total, DELTA);
    }

    // --- getTax ---
    @Test
    void tax_electronics() {
        Product p = new Product("Laptop", Category.ELECTRONICS, 100, 2);
        assertEquals(20, p.getTax(CustomerType.REGULAR), DELTA); // 200 * 0.1
    }

    @Test
    void tax_clothing() {
        Product p = new Product("Shirt", Category.CLOTHING, 100, 1);
        assertEquals(8, p.getTax(CustomerType.REGULAR), DELTA); // 100 * 0.08
    }

    @Test
    void tax_food_vip() {
        Product p = new Product("Apple", Category.FOOD, 100, 1);
        assertEquals(5, p.getTax(CustomerType.VIP), DELTA); // 100 * 0.05
    }

    @Test
    void tax_food_regular() {
        Product p = new Product("Apple", Category.FOOD, 100, 1);
        assertEquals(10, p.getTax(CustomerType.REGULAR), DELTA); // 100 * 0.1
    }

    @Test
    void tax_otherCategory_zero() {
        Product p = new Product("Widget", Category.OTHER, 100, 1);
        assertEquals(0, p.getTax(CustomerType.REGULAR), DELTA);
    }
}
