package order_processor;

public class CustomerDiscountPolicy implements DiscountPolicy {

    private final CustomerType customerType;

    public CustomerDiscountPolicy(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getDiscountRate() {
        return switch (customerType){
            case VIP -> 0.20;
            case MEMBER -> 0.10;
            case GUEST -> 0.0;
        };
    }
}
