package interview.question3;

public class Address {
    private String street;
    private Country country;

    public String getStreet() { return street; }
    public Country getCountry() { return country; }

    public boolean isUs() {
        return country.isUs();
    }
}
