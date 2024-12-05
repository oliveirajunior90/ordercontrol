package com.system.ordercontrol.order;

import com.system.ordercontrol.domain.model.Order;
import com.system.ordercontrol.order.dto.CreateOrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<HttpStatus> createOrder(CreateOrderDTO dto) {
        orderService.create(dto.toOrder());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    public ResponseEntity<String> delete(UUID id) {
        orderService.delete(id);
        return ResponseEntity.status(202).body("order deleted succesfuly");
    }

    public ResponseEntity<Optional<Order>> getOrder(UUID id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Iterable<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}
