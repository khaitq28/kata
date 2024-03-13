package movierental.price;


import movierental.Price;
import movierental.PriceCode;

public class NewReleasePrice extends Price {

    @Override
    protected double getAmount(int rentedDays) {
        return rentedDays * 3;
    }

    @Override
    protected PriceCode getPriceCode() {
        return PriceCode.NEW_RELEASE;
    }

}
