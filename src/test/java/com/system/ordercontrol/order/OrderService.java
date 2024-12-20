package com.system.ordercontrol.order;

import com.system.ordercontrol.entity.model.Ingredient;
import com.system.ordercontrol.entity.model.OrderItem;
import com.system.ordercontrol.entity.model.Product;
import com.system.ordercontrol.ingredients.IngredientRepository;
import com.system.ordercontrol.ingredients.IngredientService;
import com.system.ordercontrol.order.dto.CreateOrderDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceTest {


    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Mock
    private IngredientService ingredientService;

    @Mock
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private CreateOrderDTO createOrderDtoWithIngredients(boolean hasEnoughIngredients) {
        Ingredient ingredient1 = new Ingredient(1222310L, "banana", 5, "ml", "banana");
        Ingredient ingredient2 = new Ingredient(1222310L, "farinha", 3, "ml", "farinha");

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Product product1 = new Product(1L, "bolo de banana", "gostoso bolinho", 15.00, "bolo-de-banana", ingredients);
        Product product2 = new Product(2L, "bolo de banana2", "gostoso bolinho2", 15.00, "bolo-de-banana", ingredients);

        List<Product> products = List.of(product1, product2);

        Set<OrderItem> items = new HashSet<>();
        items.add(new OrderItem(1L, 2));
        items.add(new OrderItem(2L, 3));

        var orderDto = new CreateOrderDTO("John Doe", "teste@teste.com", items);

        when(ingredientService.hasEnoughIngredients(products)).thenReturn(hasEnoughIngredients);
        when(orderRepository.save(orderDto.toOrder())).thenReturn(orderDto.toOrder());

        return orderDto;
    }


    @Test
    void createOrderWhenHasIngredients() throws Exception {
        var orderDto = createOrderDtoWithIngredients(true);
        orderService.create(orderDto);
        verify(orderRepository).save(orderDto.toOrder());
    }
}
