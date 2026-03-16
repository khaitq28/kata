package packing_lot;

public class ParkingLot {
    private int availableSpot;
    private boolean[] spots;

    public ParkingLot() {
        this.availableSpot = 100;
        this.spots = new boolean[100];
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        if (getAvailableSpot() < vehicle.getNumberOfSpotNeeded())
            throw new RuntimeException("Impossible to park this vehicle");

        for (int i = 0; i < spots.length; i++) {
            int j = i + vehicle.getNumberOfSpotNeeded() - 1;
            if (j >= spots.length) break;
            if (isFreeSpotBlock(i, j)) {
                this.availableSpot -= vehicle.getNumberOfSpotNeeded();
                updateSpot(i, j, true);
                return new Ticket(vehicle, i);
            }
        }
        throw new RuntimeException("Impossible to park this vehicle");
    }

    private boolean isFreeSpotBlock(int i, int j) {
        for (int k = i; k <= j; k++) {
            if (spots[k])   // spot is occupied
                return false;
        }
        return true;
    }

    private void updateSpot(int i, int j, boolean occupied) {
        for (int k = i; k <= j; k++)
            spots[k] = occupied;
    }

    public void checkOutVehicle(Ticket ticket) {
        ticket.checkout();
        int j = ticket.getSpotStart() + ticket.getVehicle().getNumberOfSpotNeeded() - 1;
        updateSpot(ticket.getSpotStart(), j, false);
        this.availableSpot += ticket.getVehicle().getNumberOfSpotNeeded();
    }

    public int getAvailableSpot() {
        return availableSpot;
    }

}
