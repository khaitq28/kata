package telldontaskkata.useCase;

import lombok.Getter;

@Getter
public class OrderRejectRequest extends OrderRequest {
    public OrderRejectRequest(int orderId) {
        super(orderId);
    }
}
