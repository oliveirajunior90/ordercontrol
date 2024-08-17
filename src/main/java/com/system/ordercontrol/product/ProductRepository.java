package com.system.ordercontrol.product;

import com.system.ordercontrol.domain.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Override
    Optional<Product> findById(UUID id);

    @Override
    Iterable<Product> findAll();
}
