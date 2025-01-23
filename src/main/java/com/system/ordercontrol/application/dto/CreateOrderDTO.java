package com.system.ordercontrol.application.dto;

import com.system.ordercontrol.domain.entity.Order;
import com.system.ordercontrol.domain.entity.OrderItem;
import java.util.Set;
import java.util.UUID;

public record CreateOrderDTO(String customerName, String customerEmail, Set<OrderItem> items) {

  public Order toOrder() {
    return new Order(UUID.randomUUID(), customerName, customerEmail, items);
  }
}
