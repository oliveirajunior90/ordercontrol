package com.system.ordercontrol.ingredients;

import com.system.ordercontrol.domain.model.Ingredient;
import com.system.ordercontrol.domain.model.OrderItem;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IngredientService {

    IngredientRepository ingredientRepository;

    IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public boolean hasEnoughIngredients(Set<OrderItem> orderItems) {

        List<Ingredient> ingredients = ingredientRepository.findBySlugIn(orderItems.stream()
                .map(OrderItem::getSlug)
                .collect(Collectors.toSet()));


        return ingredients.size() > orderItems.size();
    }
}
