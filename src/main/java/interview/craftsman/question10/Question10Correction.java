package interview.craftsman.question10;

public class Question10Correction {

    public record Money (double amount, String currency) {
        public Money {
            if (amount < 0)
                throw new IllegalArgumentException("Amount cannot be negative");
            if (currency == null || currency.length() != 3)
                throw new IllegalArgumentException("Invalid currency code");
        }
    }

    public record Email (String email) {
        public Email {
            if (email == null || !email.contains("@"))
                throw new IllegalArgumentException("Invalid email");
        }
    }


    public void processPayment(Email email, Money money) {
        System.out.println("Processing " + money.amount() + " " + money.currency() + " for " + email.email());
    }

    public void refund(Email email, Money money) {
        System.out.println("Refunding " + money.amount() + " " + money.currency() + " to " + email.email());

    }

    public void sendReceipt(Email email, Money money) {
        System.out.println("Sending receipt for " + money.amount() + " " + money.currency() + " to " + email.email());
    }
}
