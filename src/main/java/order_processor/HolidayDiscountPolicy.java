package order_processor;

public class HolidayDiscountPolicy implements DiscountPolicy {

    private final boolean holiday;

    public HolidayDiscountPolicy(boolean isHoliday) {
        this.holiday = isHoliday;
    }

    @Override
    public double getDiscountRate() {
        return holiday ?  0.05 : 0.0;
    }
}
