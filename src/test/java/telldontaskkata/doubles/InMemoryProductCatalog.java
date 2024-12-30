package telldontaskkata.doubles;

import telldontaskkata.domain.Product;
import telldontaskkata.repository.ProductCatalog;

import java.util.List;
import java.util.Optional;

public class InMemoryProductCatalog implements ProductCatalog {
    private final List<Product> products;

    public InMemoryProductCatalog(List<Product> products) {
        this.products = products;
    }

    public Optional<Product> getByName(final String name) {
        return products.stream().filter(p -> p.getName().equals(name)).findFirst();
    }
}
