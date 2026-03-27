package interview.craftsman.question3;

import java.util.List;

public class Order {
    private Customer customer;
    private Shipment shipment;
    private List<Item> items;

    public Customer getCustomer() { return customer; }
    public Shipment getShipment() { return shipment; }
    public List<Item> getItems() { return items; }

    public void processShipmentPrice() {

        if (!customer.isUs()) return;

        double totalPrice = items.stream()
                .mapToDouble(Item::getPrice)
                .sum() * 0.1;

        shipment.processUsShipment(totalPrice);
    }
}
