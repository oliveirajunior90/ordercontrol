package com.system.ordercontrol.ingredients;

import com.system.ordercontrol.domain.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findBySlugIn(Set<String> slugs);
}
