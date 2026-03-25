package interview.question3;

public class Customer {
    private String name;
    private Address address;

    public String getName() { return name; }
    public Address getAddress() { return address; }

    public boolean isUs() {
        return address.isUs();
    }
}
