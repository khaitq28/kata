package order_processor;

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
 */
public class OrderProcessor {

    public String process(String customerType, String paymentMethod, List<String> items, boolean isHoliday) {
        if (items == null || items.isEmpty()) {
            return "ERROR: no items";
        }

        // --- Calculate subtotal ---
        double subtotal = 0;
        for (String item : items) {
            if (item.equals("BOOK"))       subtotal += 12.0;
            else if (item.equals("PEN"))   subtotal += 1.5;
            else if (item.equals("BAG"))   subtotal += 35.0;
            else return "ERROR: unknown item " + item;
        }

        // --- Apply discount ---
        double discount = 0;
        if (customerType.equals("VIP")) {
            discount = subtotal * 0.20;
        } else if (customerType.equals("MEMBER")) {
            discount = subtotal * 0.10;
        } else if (!customerType.equals("GUEST")) {
            return "ERROR: unknown customer type";
        }

        if (isHoliday) {
            discount += subtotal * 0.05;
        }

        double discountedPrice = subtotal - discount;

        // --- Apply tax ---
        double tax = 0;
        if (paymentMethod.equals("CREDIT_CARD")) {
            tax = discountedPrice * 0.10;
        } else if (paymentMethod.equals("CASH")) {
            tax = discountedPrice * 0.08;
        } else if (paymentMethod.equals("CRYPTO")) {
            tax = discountedPrice * 0.05;
        } else {
            return "ERROR: unknown payment method";
        }

        double total = discountedPrice + tax;

        // --- Send confirmation ---
        String confirmation;
        if (paymentMethod.equals("CREDIT_CARD")) {
            confirmation = "Charged $" + String.format("%.2f", total) + " to credit card.";
        } else if (paymentMethod.equals("CASH")) {
            confirmation = "Please pay $" + String.format("%.2f", total) + " in cash at counter.";
        } else {
            confirmation = "Send $" + String.format("%.2f", total) + " to crypto wallet 0xABCD.";
        }

        // --- Log order ---
        System.out.println("[LOG] Order processed for " + customerType + ": " + confirmation);

        return confirmation;
    }
}
