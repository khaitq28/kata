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
    private final LocalDateTime start;
    private LocalDateTime end;

    public Ticket(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.id = UUID.randomUUID().toString();
        this.start = LocalDateTime.now();
    }

    public void validate() {
        if (this.end != null) {
            System.out.println("Ticket has been validated");
            return;
        }
        this.end = LocalDateTime.now();
    }

    public double getTicketFee() {
        if (this.end == null) throw new RuntimeException("Need to be Validated");
        long durationInHour = ChronoUnit.MINUTES.between(start, end);
        return Math.ceil(durationInHour * this.vehicle.getPricePerHour() / 60);
    }
}
