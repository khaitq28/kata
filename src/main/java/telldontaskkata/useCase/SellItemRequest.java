package telldontaskkata.useCase;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellItemRequest {
    private int quantity;
    private String productName;

}
