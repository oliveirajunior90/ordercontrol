package com.system.ordercontrol.order;

import com.system.ordercontrol.domain.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public void upsert(Order order) {
        orderRepository.save(order);
    }

    public void delete(UUID id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> getOrder(UUID id) {
        return Optional.empty();
    }

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }
}
