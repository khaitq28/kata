package order_processor;

import java.util.ArrayList;
import java.util.List;

/**
 * KATA: Order Processor
 *
 * This class handles the full lifecycle of placing an order.
 * It works — but it's a mess. Your job is to refactor it.
 *
 * Hints to look for:
 * - SRP violations
 * - OCP violations (what happens when a new payment type or discount rule is added?)
 * - Testability issues
 * - Magic numbers / strings
 * - Missing abstractions
 *
 *
 *
 *   - What changes when a new item, discount rule, or payment method is added?
 */
public class OrderProcessor {

    public String process(String customerType, String paymentMethod, List<String> items, boolean isHoliday) {

        if (items == null || items.isEmpty()) return "ERROR: no items";

        CustomerType customerTypeEnum = CustomerType.fromString(customerType);
        PaymentMethod paymentMethodEnum = PaymentMethod.fromString(paymentMethod);

        if (paymentMethodEnum == null) return "ERROR: unknown payment method";
        if (customerTypeEnum == null) return "ERROR: unknown customer type";

        List<Item> itemsList = new ArrayList<>();
        for (String item : items) {
            Item itemEnum = Item.fromString(item);
            if (itemEnum == null) return "ERROR: unknown item " + item;
            itemsList.add(itemEnum);
        }

        List<DiscountPolicy> discountPolicies =  List.of(
                new CustomerDiscountPolicy(customerTypeEnum),
                new HolidayDiscountPolicy(isHoliday)
        );

        Order order = new Order(paymentMethodEnum, itemsList, discountPolicies);

        return order.getConfirmation();
    }
}
