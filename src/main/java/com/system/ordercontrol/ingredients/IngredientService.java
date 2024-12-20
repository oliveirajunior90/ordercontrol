package com.system.ordercontrol.ingredients;

import com.system.ordercontrol.entity.model.Product;

import java.util.List;

public class IngredientService {

    IngredientRepository ingredientRepository;
    
    IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public boolean hasEnoughIngredients(List<Product> products) {

        return true;
    }
}
