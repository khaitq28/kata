package telldontaskkata.useCase;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderShipmentRequest extends OrderRequest {
    public OrderShipmentRequest(int orderId) {
        super(orderId);
    }
}
