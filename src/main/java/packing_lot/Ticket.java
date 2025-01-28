package packing_lot;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

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

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void validate() {
        if (this.end != null) {
            System.out.println("Ticket has been validated");
            return;
        }
        this.end = LocalDateTime.now();
    }
    public double getFee() {
        if (this.end == null) throw new RuntimeException("Need to be Validated");
        long durationInHour = ChronoUnit.HOURS.between(start, end);
        return durationInHour * this.vehicle.getBasePricePerHour();
    }
}
