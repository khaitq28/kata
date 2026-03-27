package interview.craftsman.question7;

public class UsTaxCalculator implements  TaxCalculator {

    @Override
    public double calculateTax(double amount) {
        return 0.08 * amount;
    }
}
