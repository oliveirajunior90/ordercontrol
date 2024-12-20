package com.system.ordercontrol.order;

import com.system.ordercontrol.entity.model.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface OrderRepository extends CrudRepository<Order, UUID> {

    @NotNull
    @Override
    Order save(@NotNull Order order);

    @Override
    Optional<Order> findById(UUID id);

    @Override
    void deleteById(UUID id);

    @Override
    Iterable<Order> findAll();
}
