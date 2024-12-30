package telldontaskkata.useCase;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderApprovalRequest {
    private int orderId;
    private boolean approved;
}
