package packing_lot;

public abstract class Vehicle {
    protected VehicleType type;
    public VehicleType getType() {
        return type;
    }
    public abstract int getNumberOfSpotNeeded();
}
