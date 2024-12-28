package telldontaskkata.useCase;

import telldontaskkata.repository.OrderRepository;
import telldontaskkata.repository.ProductCatalog;
import telldontaskkata.domain.Order;
import telldontaskkata.domain.OrderItem;
import telldontaskkata.domain.OrderStatus;
import telldontaskkata.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.HALF_UP;

public class OrderCreationUseCase {
    private final OrderRepository orderRepository;
    private final ProductCatalog productCatalog;

    public OrderCreationUseCase(OrderRepository orderRepository, ProductCatalog productCatalog) {
        this.orderRepository = orderRepository;
        this.productCatalog = productCatalog;
    }

    public void run(SellItemsRequest request) {
        Order order = new Order();
        order.setStatus(OrderStatus.CREATED);
        order.setItems(new ArrayList<>());
        order.setCurrency("EUR");
        order.setTotal(new BigDecimal("0.00"));
        order.setTax(new BigDecimal("0.00"));

        for (SellItemRequest itemRequest : request.getRequests()) {
            Product product = productCatalog.getByName(itemRequest.getProductName());

            if (product == null) {
                throw new UnknownProductException();
            }
            else {
                final BigDecimal unitaryTax = product.getPrice().divide(valueOf(100)).multiply(product.getCategory().getTaxPercentage()).setScale(2, HALF_UP);
                final BigDecimal unitaryTaxedAmount = product.getPrice().add(unitaryTax).setScale(2, HALF_UP);
                final BigDecimal taxedAmount = unitaryTaxedAmount.multiply(valueOf(itemRequest.getQuantity())).setScale(2, HALF_UP);
                final BigDecimal taxAmount = unitaryTax.multiply(valueOf(itemRequest.getQuantity()));

                final OrderItem orderItem = OrderItem.builder()
                        .product(product).quantity(itemRequest.getQuantity())
                        .tax(taxAmount)
                        .taxedAmount(taxedAmount)
                        .build();

                order.getItems().add(orderItem);

                order.setTotal(order.getTotal().add(taxedAmount));
                order.setTax(order.getTax().add(taxAmount));
            }
        }

        orderRepository.save(order);
    }
}