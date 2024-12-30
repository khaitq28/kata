package telldontaskkata.useCase;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderApprovalRequest extends OrderRequest {

    public OrderApprovalRequest(int orderId) {
        super(orderId);
    }
}
