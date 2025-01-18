package telldontaskkata.useCase;

import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderItem;
import telldontaskkata.domain.OrderStatus;
import telldontaskkata.domain.Product;
import telldontaskkata.repository.OrderRepository;
import telldontaskkata.repository.ProductCatalog;

import java.util.ArrayList;

public class OrderCreationUseCase {
    private final OrderRepository orderRepository;
    private final ProductCatalog productCatalog;

    public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
        this.orderRepository = orderRepository;
        this.productCatalog = productCatalog;
    }

    public void run(SellItemsRequest request) {

        Order order = new Order();
        order.setCurrency("EUR");

        for (SellItemRequest itemRequest : request.getRequests()) {
            Product product = productCatalog.getByName(itemRequest.getProductName()).orElseThrow(UnknownProductException::new);
            final OrderItem orderItem = new OrderItem(product, itemRequest.getQuantity());
            order.addOrderItem(orderItem);
        }
        orderRepository.save(order);
    }
}
