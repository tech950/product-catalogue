package com.product.catalogue.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product save(Product product);

    Optional<Product> findById(String id);
}
