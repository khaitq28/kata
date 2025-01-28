package packing_lot;

public class Bike extends Vehicle {
    public Bike() {
        this.type = VehicleType.BIKE;
    }
    @Override
    public int getNumberOfSpotNeeded() {
        return 1;
    }

    @Override
    public double getBasePricePerHour() {
        return 0;
    }

}
