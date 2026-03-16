package packing_lot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
    }

    // --- parkVehicle ---

    @Test
    void parkVehicle_reducesAvailableSpots() {
        parkingLot.parkVehicle(new Car());
        assertEquals(98, parkingLot.getAvailableSpot()); // Car needs 2 spots
    }

    @Test
    void parkVehicle_returnsTicketWithCorrectVehicle() {
        Car car = new Car();
        Ticket ticket = parkingLot.parkVehicle(car);
        assertEquals(car, ticket.getVehicle());
    }

    @Test
    void parkVehicle_multipleVehiclesReduceSpotsCorrectly() {
        parkingLot.parkVehicle(new Car());    // -2 → 98
        parkingLot.parkVehicle(new Truck());  // -4 → 94
        parkingLot.parkVehicle(new Bike());   // -1 → 93
        assertEquals(93, parkingLot.getAvailableSpot());
    }

    @Test
    void parkVehicle_throwsWhenLotIsFull() {
        // Fill the lot with bikes (1 spot each), 100 bikes = 100 spots
        for (int i = 0; i < 100; i++) {
            parkingLot.parkVehicle(new Bike());
        }
        assertEquals(0, parkingLot.getAvailableSpot());
        assertThrows(RuntimeException.class, () -> parkingLot.parkVehicle(new Bike()));
    }

    @Test
    void parkVehicle_throwsWhenNotEnoughContiguousSpots() {
        // Fill all spots except 1 (not enough for a Car which needs 2)
        for (int i = 0; i < 99; i++) {
            parkingLot.parkVehicle(new Bike());
        }
        assertEquals(1, parkingLot.getAvailableSpot());
        assertThrows(RuntimeException.class, () -> parkingLot.parkVehicle(new Car()));
    }

    // --- checkOutVehicle ---

    @Test
    void checkOutVehicle_restoresAvailableSpots() {
        Ticket ticket = parkingLot.parkVehicle(new Car());
        assertEquals(98, parkingLot.getAvailableSpot());

        parkingLot.checkOutVehicle(ticket);
        assertEquals(100, parkingLot.getAvailableSpot());
    }

    @Test
    void checkOutVehicle_freesSpotsSoAnotherVehicleCanPark() {
        // Fill the lot completely with bikes
        Ticket[] tickets = new Ticket[100];
        for (int i = 0; i < 100; i++) {
            tickets[i] = parkingLot.parkVehicle(new Bike());
        }
        assertEquals(0, parkingLot.getAvailableSpot());

        // Check out 2 adjacent bikes to free up 2 contiguous spots for a Car
        parkingLot.checkOutVehicle(tickets[0]);
        parkingLot.checkOutVehicle(tickets[1]);
        assertEquals(2, parkingLot.getAvailableSpot());

        // A Car (needs 2 contiguous spots) should now be able to park
        assertDoesNotThrow(() -> parkingLot.parkVehicle(new Car()));
    }

    @Test
    void checkOutVehicle_throwsOnDoubleCheckout() {
        Ticket ticket = parkingLot.parkVehicle(new Car());
        parkingLot.checkOutVehicle(ticket);
        assertThrows(IllegalStateException.class, () -> parkingLot.checkOutVehicle(ticket));
    }

    @Test
    void checkOutVehicle_truckRestoresFourSpots() {
        Ticket ticket = parkingLot.parkVehicle(new Truck());
        assertEquals(96, parkingLot.getAvailableSpot());

        parkingLot.checkOutVehicle(ticket);
        assertEquals(100, parkingLot.getAvailableSpot());
    }
}
