package com.system.ordercontrol.order;

import com.system.ordercontrol.entity.model.Ingredient;
import com.system.ordercontrol.entity.model.Order;
import com.system.ordercontrol.entity.model.OrderItem;
import com.system.ordercontrol.entity.model.Product;
import com.system.ordercontrol.ingredients.IngredientService;
import com.system.ordercontrol.ingredients.exception.InsufficientIngredientsException;
import com.system.ordercontrol.order.dto.CreateOrderDTO;
import com.system.ordercontrol.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
