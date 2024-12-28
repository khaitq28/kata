package telldontaskkata.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Category {
    private String name;
    private BigDecimal taxPercentage;
}
