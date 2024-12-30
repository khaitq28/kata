package telldontaskkata.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

@Getter
@Setter
public class Product {
    private String name;
    private BigDecimal price;
    private Category category;

    public BigDecimal getUnitaryTax() {
        return  getPrice()
                .divide(valueOf(100))
                .multiply(getCategory().getTaxPercentage())
                .setScale(2, HALF_UP);
    }

    public BigDecimal getUnitaryTaxedAmount() {
        return getPrice().add(getUnitaryTax()).setScale(2, HALF_UP);
    }
}
