package packing_lot;

public sealed abstract class Vehicle permits Car, Truck, Bike{
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

    public String getVehicleTypeName() {
        return type.getTypeName();
    }
}
