package com.system.ordercontrol.order;

import com.system.ordercontrol.entity.model.Order;
import com.system.ordercontrol.order.dto.CreateOrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody CreateOrderDTO dto) throws Exception {
        orderService.create(dto);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrder(UUID id) {
        return ResponseEntity.ok(orderService.getOrder(id));
    }


    @GetMapping
    public ResponseEntity<Iterable<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}
