package packing_lot;

public class ParkingLot {

    private int availableSpot;
    public ParkingLot() {
        this.availableSpot = 100;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (availableSpot < vehicle.getNumberOfSpotNeeded())
            throw new RuntimeException("Impossible to park this vehicle");
        this.availableSpot -= vehicle.getNumberOfSpotNeeded();
    }

    public void unParkVehicle(Vehicle vehicle) {
        this.availableSpot += vehicle.getNumberOfSpotNeeded();
    }

    public int getAvailableSpot() {
        return this.availableSpot;
    }

    // Add a feature to calculate parking fees based on the duration of parking.
}
