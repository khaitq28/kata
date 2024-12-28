package telldontaskkata.domain;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class OrderItem {
    private final Product product;
    private final int quantity;
    private final BigDecimal taxedAmount;
    private final BigDecimal tax;

}
