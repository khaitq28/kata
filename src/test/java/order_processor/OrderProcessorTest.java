package order_processor;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrderProcessorTest {

    private final OrderProcessor processor = new OrderProcessor();

    @Test
    void guest_pays_cash_no_holiday() {
        String result = processor.process("GUEST", "CASH", List.of("BOOK"), false);
        // BOOK=12.0, no discount, tax=8% → 12 * 1.08 = 12.96
        assertThat(result).isEqualTo("Please pay $12.96 in cash at counter.");

        result = processor.process("GUEST", "CASH", List.of("PEN"), false);
        assertThat(result).isEqualTo("Please pay $1.62 in cash at counter.");

    }

    @Test
    void guest_pays_by_new_method() {
        String result = processor.process("GUEST", "NEWMETHOD", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("ERROR: unknown payment method");
    }

    @Test
    void newcustomer_pays_by_new_method() {
        String result = processor.process("GUESTXX", "CASH", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("ERROR: unknown customer type");
    }



    ///  GUEST
    @Test
    void guest_pays_cash_not_holiday() {
        String result = processor.process("GUEST", "CASH", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Please pay $52.38 in cash at counter.");
    }
    @Test
    void guest_pays_cash_holiday() {
        String result = processor.process("GUEST", "CASH", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Please pay $49.76 in cash at counter.");
    }
    @Test
    void guest_pays_credit_card_not_holiday() {
        String result = processor.process("GUEST", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Charged $53.35 to credit card.");
    }
    @Test
    void guest_pays_credit_card_holiday() {
        String result = processor.process("GUEST", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Charged $50.68 to credit card.");
    }
    @Test
    void guest_pays_crypto_not_holiday() {
        String result = processor.process("GUEST", "CRYPTO", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Send $50.93 to crypto wallet 0xABCD.");
    }
    @Test
    void guest_pays_crypto_holiday() {
        String result = processor.process("GUEST", "CRYPTO", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Send $48.38 to crypto wallet 0xABCD.");
    }


    // MEMBER
    @Test
    void member_pays_cash_not_holiday() {
        String result = processor.process("MEMBER", "CASH", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Please pay $47.14 in cash at counter.");
    }
    @Test
    void member_pays_cash_holiday() {
        String result = processor.process("MEMBER", "CASH", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Please pay $44.52 in cash at counter.");
    }
    @Test
    void member_pays_credit_card_not_holiday() {
        String result = processor.process("MEMBER", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Charged $48.02 to credit card.");
    }
    @Test
    void member_pays_credit_card_holiday() {
        String result = processor.process("MEMBER", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Charged $45.35 to credit card.");
    }
    @Test
    void member_pays_crypto_not_holiday() {
        String result = processor.process("MEMBER", "CRYPTO", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Send $45.83 to crypto wallet 0xABCD.");
    }
    @Test
    void member_pays_crypto_holiday() {
        String result = processor.process("MEMBER", "CRYPTO", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Send $43.29 to crypto wallet 0xABCD.");
    }



    //------VIP-----
    @Test
    void vip_pays_cash_not_holiday() {
        String result = processor.process("VIP", "CASH", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Please pay $41.90 in cash at counter.");
    }
    @Test
    void vip_pays_cash_holiday() {
        String result = processor.process("VIP", "CASH", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Please pay $39.29 in cash at counter.");
    }
    @Test
    void vip_pays_credit_card_not_holiday() {
        String result = processor.process("VIP", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Charged $42.68 to credit card.");
    }
    @Test
    void vip_pays_credit_card_holiday() {
        String result = processor.process("VIP", "CREDIT_CARD", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Charged $40.01 to credit card.");
    }
    @Test
    void vip_pays_crypto_not_holiday() {
        String result = processor.process("VIP", "CRYPTO", List.of("BOOK","PEN", "BAG"), false);
        assertThat(result).isEqualTo("Send $40.74 to crypto wallet 0xABCD.");
    }
    @Test
    void vip_pays_crypto_holiday() {
        String result = processor.process("VIP", "CRYPTO", List.of("BOOK","PEN", "BAG"), true);
        assertThat(result).isEqualTo("Send $38.19 to crypto wallet 0xABCD.");
    }

    //------------------

    @Test
    void returns_error_for_empty_items() {
        assertThat(processor.process("GUEST", "CASH", List.of(), false))
                .isEqualTo("ERROR: no items");

        assertThat(processor.process("GUEST", "CASH", null, false))
                .isEqualTo("ERROR: no items");
    }

    @Test
    void returns_error_for_unknown_item() {
        assertThat(processor.process("GUEST", "CASH", List.of("UNKNOWN"), false))
                .startsWith("ERROR: unknown item");
    }



    //
    @Test
    void item_prices_are_correct() {
        // Each item alone, simplest path: GUEST + CASH + no holiday (no discount, tax=8%)
        assertThat(processor.process("GUEST", "CASH", List.of("BOOK"), false))
                .isEqualTo("Please pay $12.96 in cash at counter.");  // 12.0 * 1.08
        assertThat(processor.process("GUEST", "CASH", List.of("PEN"), false))
                .isEqualTo("Please pay $1.62 in cash at counter.");   // 1.5 * 1.08
        assertThat(processor.process("GUEST", "CASH", List.of("BAG"), false))
                .isEqualTo("Please pay $37.80 in cash at counter.");  // 35.0 * 1.08
    }

}
