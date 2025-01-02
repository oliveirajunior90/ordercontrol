package com.system.ordercontrol.application.service;

import com.system.ordercontrol.domain.entity.Order;
import com.system.ordercontrol.application.dto.CreateOrderDTO;
import com.system.ordercontrol.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void create(CreateOrderDTO orderDto) {
        orderRepository.save(orderDto.toOrder());
    }

    public Optional<Order> getOrder(UUID id) {
        return Optional.empty();
    }

    public Iterable<Order> getOrders() {
        return orderRepository.findAll();
    }

//    private Map<String, Double> getTotalPerIngredient(List<Product> products) {
//        return products.stream().flatMap(product -> product.getIngredients().stream())
//            .collect(Collectors.groupingBy(
//                    Ingredient::getName,
//                    Collectors.summingDouble(Ingredient::getQuantityInStock)
//            ));
//    }
}
