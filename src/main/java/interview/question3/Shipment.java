package interview.question3;


public class Shipment {
    private String carrier;
    private double price;

    public void setCarrier(String carrier) { this.carrier = carrier; }

    private void setPrice(double price) { this.price = price; }

    public void processUsShipment(double price) {
        setCarrier("UPS");
        setPrice(price);
    }
}
