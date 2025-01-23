package com.system.ordercontrol.application.api.v1.controller;
import com.system.ordercontrol.application.dto.CreateOrderDTO;
import com.system.ordercontrol.application.service.NotificationCreateOrderService;
import com.system.ordercontrol.application.service.OrderService;
import com.system.ordercontrol.application.usecase.CreateOrderUseCase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import com.system.ordercontrol.domain.entity.OrderItem;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderControllerV1IT {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Mock
    OrderControllerV1 orderControllerV1;

    @Mock
    CreateOrderUseCase createOrderUseCase;

    @Mock
    OrderService orderService;

    @MockBean
    NotificationCreateOrderService notificationCreateOrderService;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(
            "postgres:16-alpine"
    );

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }


    @Test
    public void CreateOrderIT() {

        OrderItem orderItem1 = new OrderItem(1L, 5);
        OrderItem orderItem2 = new OrderItem(2L, 6);

        Set<OrderItem> orderItems = new HashSet<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);


        CreateOrderDTO dto = new CreateOrderDTO("John Doe","john.doe@example.com", orderItems);


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<CreateOrderDTO> request = new HttpEntity<>(dto, headers);

        String url = String.format("http://localhost:%d/api/v1/order", port);

        ResponseEntity<HttpStatus> response = restTemplate.exchange(url, HttpMethod.POST, request, HttpStatus.class);

        assertEquals(200, response.getStatusCode().value());
        assertNotNull(response.getBody());
    }
}
