package packing_lot;

public abstract class Vehicle {
    protected VehicleType type;
    public VehicleType getType() {
        return type;
    }
    public int getNumberOfSpotNeeded() {
        return type.getSlotNeed();
    }

    public double getBasePricePerHour() {
        return type.getPricePerHour();
    }
}
