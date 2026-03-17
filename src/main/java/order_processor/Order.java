package order_processor;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Order {
    private PaymentMethod paymentMethod;
    private List<Item> items;
    private final List<DiscountPolicy> discountPolicies;

    public String getConfirmation() {
        return paymentMethod.getConfirmation(getTotal());
    }

    private double getTotal() {
        double totalSum = getTotalSum();
        double discount = getTotalDiscount(totalSum);
        double discountedPrice = totalSum - discount;
        double tax = discountedPrice * paymentMethod.getFeeRate();
        return discountedPrice + tax;
    }

    private double getTotalDiscount(double subtotal) {
        return discountPolicies.stream()
                .mapToDouble(discountPolicy -> subtotal * discountPolicy.getDiscountRate())
                .sum();
    }

    private double getTotalSum() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

}
