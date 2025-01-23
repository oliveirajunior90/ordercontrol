package com.system.ordercontrol.application.service;

import com.system.ordercontrol.application.dto.CreateOrderDTO;
import com.system.ordercontrol.domain.entity.Order;
import com.system.ordercontrol.domain.repository.OrderRepository;
import java.util.*;
import org.springframework.stereotype.Service;

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

}
