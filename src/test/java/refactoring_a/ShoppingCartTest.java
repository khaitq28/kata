package refactoring_a;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Write comprehensive tests first (like you did with GildedRose)
 * Refactor the code to be clean and maintainable
 * Extract methods, constants, and improve readability
 * Ensure all tests pass after each refactoring step
 */

class ShoppingCartTest {

    // TODO: Write comprehensive tests here
    // Test all combinations:
    // - Different customer types (Regular, Premium, VIP)
    // - Different categories (Electronics, Clothing, Food)
    // - Holiday season vs normal
    // - Different loyalty point levels
    // - Different quantities (bulk discounts)
    // - Tax calculations


}


/*
        Electronics:
            Regular: 5% discount
            Premium: 10% discount
            VIP: 15% discount
            Tax: 10%
        Clothing:
            Regular: No discount (unless holiday)
            Premium: 10% discount (15% on holiday)
            VIP: 15% discount (25% on holiday)
            Holiday: Regular gets 15% discount
            Tax: 8%
        Food:
            Bulk (10+): 10% discount
            VIP: Additional 5% discount
            Tax: 10% (5% for VIP)
        Loyalty points:
            1000+: VIP 10%, Premium 5%, Regular 2%
            500-999: Premium/VIP 3%
        Bulk quantity:
            20+: 5% discount
            10-19: 3% discount
 */