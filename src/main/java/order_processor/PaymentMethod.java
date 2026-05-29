package order_processor;

import lombok.Getter;

import java.util.Arrays;

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
        return Arrays.stream(PaymentMethod.values())
                .filter(e -> e.name().equals(paymentMethod))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Unknown payment method: " + paymentMethod));
    }

    public  String getConfirmation(double total) {
        return switch (this) {
            case CREDIT_CARD -> "Charged $" + String.format("%.2f", total) + " to credit card.";
            case CASH -> "Please pay $" + String.format("%.2f", total) + " in cash at counter.";
            case CRYPTO -> "Send $" + String.format("%.2f", total) + " to crypto wallet 0xABCD.";
        };
    }
}
