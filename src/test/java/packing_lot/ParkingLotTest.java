package packing_lot;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ParkingLotTest {


    @Test
    void parkVehicle() {

        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        when(parkingLot.getAvailableSpot()).thenReturn(0);

        parkingLot.parkVehicle(new Car());

//        assertThrows(RuntimeException.class, () -> parkingLot.parkVehicle(new Car()));

    }

    @Test
    void checkOutVehicle() {
    }

    @Test
    void getAvailableSpot() {
    }
}