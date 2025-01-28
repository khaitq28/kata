package packing_lot;

public class ParkingLot {
    private int availableSpot;
    public ParkingLot() {
        this.availableSpot = 100;
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        if (availableSpot < vehicle.getNumberOfSpotNeeded())
            throw new RuntimeException("Impossible to park this vehicle");
        this.availableSpot -= vehicle.getNumberOfSpotNeeded();
        return new Ticket(vehicle);
    }

    public void unParkVehicle(Ticket ticket) {
        ticket.validate();
        this.availableSpot += ticket.getVehicle().getNumberOfSpotNeeded();
    }

    public int getAvailableSpot() {
        return this.availableSpot;
    }

}
