package packing_lot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class VehicleTest {

    private Vehicle vehicle = Mockito.mock(Vehicle.class);
    @Test
    void getType() {
    }

    @Test
    void getNumberOfSpotNeeded() {
        vehicle = new Car();
        assertEquals(VehicleType.CAR.getSlotNeed(), vehicle.getNumberOfSpotNeeded());

        vehicle = new Bike();
        assertEquals(VehicleType.BIKE.getSlotNeed(), vehicle.getNumberOfSpotNeeded());

        vehicle = new Truck();
        assertEquals(VehicleType.TRUCK.getSlotNeed(), vehicle.getNumberOfSpotNeeded());
    }

    @Test
    void getBasePricePerHour() {
        vehicle = new Car();
        assertEquals(VehicleType.CAR.getPricePerHour(), vehicle.getPricePerHour());

        vehicle = new Bike();
        assertEquals(VehicleType.BIKE.getPricePerHour(), vehicle.getPricePerHour());

        vehicle = new Truck();
        assertEquals(VehicleType.TRUCK.getPricePerHour(), vehicle.getPricePerHour());
    }
}