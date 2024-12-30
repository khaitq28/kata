package telldontaskkata.useCase;

import lombok.Getter;

@Getter
public abstract class OrderRequest {
    protected final int orderId;
    protected OrderRequest(int orderId) {
        this.orderId = orderId;
    }
}
