package movierental.price;

import movierental.Price;
import movierental.PriceCode;

public class RegularPrice extends Price {
    @Override
    protected double getAmount(int daysRented) {
        if (daysRented > 2)
            return 2 + (daysRented - 2) * 1.5;
        return 2d;
    }

    @Override
    protected PriceCode getPriceCode() {
        return PriceCode.REGULAR;
    }

}
