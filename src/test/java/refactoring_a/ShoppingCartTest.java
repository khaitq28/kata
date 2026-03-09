package refactoring_a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for ShoppingCart.calculateTotal (subtotal + tax for all products).
 */
class ShoppingCartTest {

    private static final double DELTA = 0.001;

    @Test
    void singleElectronics_vip_totalPlusTax() {
        Product[] products = new Product[]{
                new Product("Laptop", Category.ELECTRONICS, 1000, 1)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.VIP, false, 0));
        // getTotal: 850, getTax: 1000*0.1=100, total 950
        assertEquals(950, cart.calculateTotal(), DELTA);
    }

    @Test
    void singleClothing_premium_holiday() {
        Product[] products = new Product[]{
                new Product("Shirt", Category.CLOTHING, 100, 1)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.PREMIUM, true, 0));
        // getTotal: 80, getTax: 8, total 88
        assertEquals(88, cart.calculateTotal(), DELTA);
    }

    @Test
    void singleFood_regular() {
        Product[] products = new Product[]{
                new Product("Apple", Category.FOOD, 50, 2)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.REGULAR, false, 0));
        // getTotal: 100, getTax: 100*0.1=10, total 110
        assertEquals(110, cart.calculateTotal(), DELTA);
    }

    @Test
    void multipleProducts_mixedCategories() {
        Product[] products = new Product[]{
                new Product("Laptop", Category.ELECTRONICS, 1000, 1),
                new Product("Shirt", Category.CLOTHING, 100, 1),
                new Product("Apple", Category.FOOD, 10, 5)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.REGULAR, false, 0));
        // Laptop: total 950, tax 100
        // Shirt: total 100, tax 8
        // Apple: total 50, tax 5
        // sum: 950+100+100+8+50+5 = 1213
        assertEquals(1213, cart.calculateTotal(), DELTA);
    }

    @Test
    void loyaltyAndBulk_discountsApplied() {
        Product[] products = new Product[]{
                new Product("Laptop", Category.ELECTRONICS, 100, 10)  // base 1000, electronics regular 950, bulk 10 950*0.97=921.5, tax 100
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.REGULAR, false, 0));
        assertEquals(921.5 + 100, cart.calculateTotal(), DELTA);
    }

    @Test
    void emptyCart_zero() {
        ShoppingCart cart = new ShoppingCart(new Product[]{}, new DiscountContext(CustomerType.REGULAR, false, 0));
        assertEquals(0, cart.calculateTotal(), DELTA);
    }

    @Test
    void loyalty1000_vip_cartTotal() {
        Product[] products = new Product[]{
                new Product("Laptop", Category.ELECTRONICS, 1000, 1),
                new Product("Widget", Category.OTHER, 100, 1)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.VIP, false, 1000));
        // Laptop: 850 * 0.9 = 765, tax 100
        // Widget: 100 * 0.9 = 90, tax 0
        assertEquals(765 + 100 + 90, cart.calculateTotal(), DELTA);
    }

    @Test
    void loyalty500_premium_cartTotal() {
        Product[] products = new Product[]{
                new Product("Widget", Category.OTHER, 100, 1)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.PREMIUM, false, 500));
        // 100 * 0.97 = 97, tax 0
        assertEquals(97, cart.calculateTotal(), DELTA);
    }

    @Test
    void loyalty500_regular_cartNoLoyaltyDiscount() {
        Product[] products = new Product[]{
                new Product("Widget", Category.OTHER, 100, 1)
        };
        ShoppingCart cart = new ShoppingCart(products, new DiscountContext(CustomerType.REGULAR, false, 500));
        assertEquals(100, cart.calculateTotal(), DELTA);
    }
}
