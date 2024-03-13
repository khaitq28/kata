package movierental;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public String statement() {
        return "\t" + movie.getTitle() + "\t" + getAmount() +"\n";
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoint(daysRented);
    }

    public double getAmount() {
        return this.movie.getAmount(daysRented);
    }
}
