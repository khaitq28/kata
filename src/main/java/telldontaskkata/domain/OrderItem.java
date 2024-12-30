package telldontaskkata.domain;

import lombok.*;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

@Getter
@Setter
public class OrderItem {
    private final Product product;
    private final int quantity;

    private final BigDecimal taxedAmount;
    private final BigDecimal tax;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

        this.tax = product.getUnitaryTax().multiply(valueOf(quantity));

        this.taxedAmount = product.getUnitaryTaxedAmount()
                                .multiply(valueOf(quantity)).setScale(2, HALF_UP);;
    }

}
