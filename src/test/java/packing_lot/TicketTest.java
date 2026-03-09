package packing_lot;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class TicketTest {

    private final EasyRandom easyRandom = new EasyRandom();
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
        Car vehicle = Mockito.mock(Car.class);
        when(vehicle.getPricePerHour()).thenReturn(10d);
        Ticket ticket = new Ticket(vehicle);
        ticket.setEnd(ticket.getStart().plusMinutes(durationInMinute));
        assertEquals(Math.ceil(vehicle.getPricePerHour()/ 60 * durationInMinute) ,ticket.getTicketFee());
    }
}