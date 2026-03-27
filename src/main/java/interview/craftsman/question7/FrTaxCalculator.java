package interview.craftsman.question7;

public class FrTaxCalculator implements  TaxCalculator {
    @Override
    public double calculateTax(double amount) {
        return amount * 0.2;
    }
}
