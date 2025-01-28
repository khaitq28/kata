package packing_lot;

import java.util.UUID;

public class Ticket {
    private String id;
    private Vehicle vehicle;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.id = UUID.randomUUID().toString();
    }
}
