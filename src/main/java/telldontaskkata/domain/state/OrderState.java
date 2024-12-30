package telldontaskkata.domain.state;

import telldontaskkata.domain.Order;

public abstract class OrderState {
    abstract void updateState(Order order);
}
