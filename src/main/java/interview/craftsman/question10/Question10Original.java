package interview.craftsman.question10;

/**
 * INTERVIEW QUESTION 10 — Original (smelly) code.
 *
 * Scenario: a payment service that takes raw primitives.
 * Validation is duplicated everywhere the service is called.
 */
public class Question10Original {

    public void processPayment(String email, double amount, String currency) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        if (currency == null || currency.length() != 3)
            throw new IllegalArgumentException("Invalid currency code");

        System.out.println("Processing " + amount + " " + currency + " for " + email);
    }

    public void refund(String email, double amount, String currency) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        if (currency == null || currency.length() != 3)
            throw new IllegalArgumentException("Invalid currency code");

        System.out.println("Refunding " + amount + " " + currency + " to " + email);
    }

    public void sendReceipt(String email, double amount, String currency) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount cannot be negative");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email");
        if (currency == null || currency.length() != 3)
            throw new IllegalArgumentException("Invalid currency code");

        System.out.println("Sending receipt for " + amount + " " + currency + " to " + email);
    }
}
