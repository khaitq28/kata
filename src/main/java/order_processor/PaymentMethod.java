package order_processor;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    CREDIT_CARD(0.1),
    CASH(0.08),
    CRYPTO(0.05);

    private final double feeRate;

    PaymentMethod(double feeRate) {
        this.feeRate = feeRate;
    }

    public static PaymentMethod fromString(String paymentMethod) {
        for (PaymentMethod pm : PaymentMethod.values()) {
            if (pm.name().equals(paymentMethod)) return pm;
        }
        return null;
    }

    public  String getConfirmation(double total) {
        return switch (this) {
            case CREDIT_CARD -> "Charged $" + String.format("%.2f", total) + " to credit card.";
            case CASH -> "Please pay $" + String.format("%.2f", total) + " in cash at counter.";
            case CRYPTO -> "Send $" + String.format("%.2f", total) + " to crypto wallet 0xABCD.";
        };
    }
}
