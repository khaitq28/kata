package telldontaskkata.doubles;

import telldontaskkata.domain.Order;
import telldontaskkata.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOrderRepository implements OrderRepository {
    private Order insertedOrder;
    private final List<Order> orders = new ArrayList<>();

    public Order getSavedOrder() {
        return insertedOrder;
    }

    public void save(Order order) {
        this.insertedOrder = order;
    }

    @Override
    public Optional<Order> getById(int orderId) {
        return orders.stream().filter(o -> o.getId() == orderId).findFirst();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
