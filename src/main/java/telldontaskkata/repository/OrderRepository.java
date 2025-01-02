package telldontaskkata.repository;

import telldontaskkata.domain.Order;

import java.util.Optional;

public interface OrderRepository {
    void save(Order order);

    Optional<Order> getById(int orderId);
}
