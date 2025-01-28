package packing_lot;

public class Truck extends Vehicle {
    public Truck() {
        this.type = VehicleType.TRUCK;
    }
    @Override
    public int getNumberOfSpotNeeded() {
        return 4;
    }
}
