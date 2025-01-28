package packing_lot;

public class Car extends Vehicle {
    public Car() {
        this.type = VehicleType.CAR;
    }
    @Override
    public int getNumberOfSpotNeeded() {
        return 2;
    }
}
