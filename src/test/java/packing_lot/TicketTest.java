package packing_lot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TicketTest {
    @Test
    void validate() {
        Ticket ticket = new Ticket(Mockito.mock(Car.class));
        ticket.setEnd(null);
        ticket.validate();
        assertNotNull(ticket.getEnd());

        LocalDateTime now = LocalDateTime.now().minusHours(1);
        ticket.setEnd(now);

        ticket.validate();
        assertEquals(now, ticket.getEnd());
    }

    @ParameterizedTest
    @ValueSource(ints = {15,30,45,60,100,240,500,4568,1000})
    void getTicketFee(int durationInMinute) {
        Vehicle vehicle = Mockito.mock(Vehicle.class);
        when(vehicle.getBasePricePerHour()).thenReturn(10d);
        Ticket ticket = new Ticket(vehicle);
        ticket.setEnd(ticket.getStart().plusMinutes(durationInMinute));
        assertEquals(Math.ceil(vehicle.getBasePricePerHour()/ 60 * durationInMinute) ,ticket.getTicketFee());
    }
}