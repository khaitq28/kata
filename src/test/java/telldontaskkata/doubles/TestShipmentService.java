package telldontaskkata.doubles;

import lombok.Getter;
import telldontaskkata.domain.Order;
import telldontaskkata.service.ShipmentService;

@Getter
public class TestShipmentService implements ShipmentService {
    private Order shippedOrder = null;

    @Override
    public void ship(Order order) {
        this.shippedOrder = order;
    }
}
