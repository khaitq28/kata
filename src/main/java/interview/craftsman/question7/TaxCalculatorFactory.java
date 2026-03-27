package interview.craftsman.question7;

public class TaxCalculatorFactory {

    public static TaxCalculator getTaxCalculator(String country) {
        if (country == null) return new DefaultTaxCalculator();
        return switch (country) {
            case "US" -> new UsTaxCalculator();
            case "FR" -> new FrTaxCalculator();
            default   -> new DefaultTaxCalculator();
        };
    }
}
