package packing_lot;

public abstract class Vehicle {
    protected VehicleType type;
    public VehicleType getType() {
        return type;
    }
    public int getNumberOfSpotNeeded() {
        return getType().getSlotNeed();
    }

    public double getPricePerHour() {
        return getType().getPricePerHour();
    }
}
