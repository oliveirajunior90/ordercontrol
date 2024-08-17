package com.system.ordercontrol.order;

import com.system.ordercontrol.domain.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {

    @Override
    Optional<Order> findById(UUID id);

    @Override
    void deleteById(UUID id);

    @Override
    Iterable<Order> findAll();
}
