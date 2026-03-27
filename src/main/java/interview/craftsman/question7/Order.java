package interview.craftsman.question7;

public class Order {

    private String id;
    private String customerEmail;
    private double amount;
    private String country;

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public double getAmount() { return amount; }
    public String getCountry() { return country; }


    private double calculateTax() {
        return TaxCalculatorFactory.getTaxCalculator(country).calculateTax(getTotal());
    }

    public double getTotal() {
       return getAmount() + calculateTax();
    }


}
