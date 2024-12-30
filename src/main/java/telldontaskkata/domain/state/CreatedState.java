package telldontaskkata.domain.state;

import telldontaskkata.domain.Order;

public class CreatedState extends OrderState {
    @Override
    void updateState(Order order) {
        order.setState(new ApprovedState());
    }
}
