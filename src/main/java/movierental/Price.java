package movierental;

public abstract class Price {

    protected abstract  double getAmount(int rentedDays);
    protected abstract  PriceCode getPriceCode();

    public  int getFrequentRenterPoint(int days) {
        return (getPriceCode() == PriceCode.NEW_RELEASE && days > 1) ? 2: 1;
    }
}
