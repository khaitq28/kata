package movierental.price;


import movierental.Price;
import movierental.PriceCode;

public class ChildrenPrice  extends Price {

    @Override
    protected double getAmount(int daysRented) {
        if (daysRented > 3)
            return  1.5 + (daysRented - 3) * 1.5;
        return 1.5;
    }

    @Override
    protected PriceCode getPriceCode() {
        return PriceCode.CHILDREN;
    }

}
