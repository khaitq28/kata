package telldontaskkata.useCase;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SellItemsRequest {
    private List<SellItemRequest> requests;

}
