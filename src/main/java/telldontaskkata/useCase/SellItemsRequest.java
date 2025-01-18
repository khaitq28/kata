package telldontaskkata.useCase;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SellItemsRequest {
    private List<SellItemRequest> requests = new java.util.ArrayList<>();

    public void addItem(SellItemRequest saladRequest) {
        requests.add(saladRequest);
    }
}
