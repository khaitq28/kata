package movierental;

public class Movie {

    private final String title;
    private final Price price;
    public Movie(String title, Price price) {
        this.title = title;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }
    protected double getAmount(int daysRented){
        return price.getAmount(daysRented);
    }
    public int getFrequentRenterPoint(int daysRented) {
        return price.getFrequentRenterPoint(daysRented);
    }
}
