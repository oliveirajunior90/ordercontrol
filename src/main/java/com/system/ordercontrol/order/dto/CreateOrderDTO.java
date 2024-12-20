package com.system.ordercontrol.order.dto;

import com.system.ordercontrol.entity.model.Order;
import com.system.ordercontrol.entity.model.OrderItem;

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
