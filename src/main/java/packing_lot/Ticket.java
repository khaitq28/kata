package packing_lot;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;


@Getter
@Setter
public class Ticket {
    private String id;
    private final Vehicle vehicle;
    private final int spotStart;
    private final LocalDateTime start;
    private LocalDateTime end;

    public Ticket(Vehicle vehicle, int spotStart) {
        this.vehicle = vehicle;
        this.spotStart = spotStart;
        this.id = UUID.randomUUID().toString();
        this.start = LocalDateTime.now();
    }

    public void checkout() {
        if (this.end != null)
            throw new IllegalStateException("Ticket already checked out");
        this.end = LocalDateTime.now();
    }

    public double getTicketFee() {
        if (this.end == null) throw new RuntimeException("Need to be Validated");
        long durationInHour = ChronoUnit.MINUTES.between(start, end);
        return Math.ceil(durationInHour * this.vehicle.getPricePerHour() / 60);
    }
}
