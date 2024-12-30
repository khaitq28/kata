package telldontaskkata.repository;

import telldontaskkata.domain.Product;

import java.util.Optional;

public interface ProductCatalog {
    Optional<Product> getByName(String name);
}
