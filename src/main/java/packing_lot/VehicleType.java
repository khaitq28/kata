package packing_lot;

public enum VehicleType {
    CAR(2,5),
    TRUCK(4,10),
    BIKE(1,1);
    private final int slotNeed;
    private final double pricePerHour;
    VehicleType(int slotNeed, double pricePerHour) {
        this.pricePerHour = pricePerHour;
        this.slotNeed = slotNeed;
    }
    public int getSlotNeed() {
        return slotNeed;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

}
