package com.system.ordercontrol.application.dto;

import com.system.ordercontrol.domain.entity.Order;
import com.system.ordercontrol.domain.entity.OrderItem;

import java.util.Set;

public record CreateOrderDTO (
        String customerName,
        String customerEmail,
        Set<OrderItem> items
) {

    public Order toOrder() {
        return new Order(customerName, customerEmail, items);
    }

}
