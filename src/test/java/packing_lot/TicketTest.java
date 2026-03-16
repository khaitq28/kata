package packing_lot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TicketTest {

    @Test
    void checkout_setsEndTime() {
        Ticket ticket = new Ticket(new Car(), 0);
        assertNull(ticket.getEnd());

        ticket.checkout();
        assertNotNull(ticket.getEnd());
    }

    @Test
    void checkout_throwsOnDoubleCheckout() {
        Ticket ticket = new Ticket(new Car(), 0);
        ticket.checkout();
        assertThrows(IllegalStateException.class, ticket::checkout);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60, 100, 240, 500, 4568, 1000})
    void getTicketFee(int durationInMinutes) {
        Car vehicle = Mockito.mock(Car.class);
        when(vehicle.getPricePerHour()).thenReturn(10d);

        Ticket ticket = new Ticket(vehicle, 0);
        ticket.setEnd(ticket.getStart().plusMinutes(durationInMinutes));

        assertEquals(Math.ceil(vehicle.getPricePerHour() / 60 * durationInMinutes), ticket.getTicketFee());
    }
}
