package com.system.ordercontrol.product;

import com.system.ordercontrol.entity.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, UUID> {

    @Override
    Optional<Product> findById(UUID id);

    List<Product> findByIdIn(List<Product> products);

    @Override
    Iterable<Product> findAll();
}
