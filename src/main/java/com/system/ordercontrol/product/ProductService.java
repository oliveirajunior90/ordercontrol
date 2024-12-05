package com.system.ordercontrol.product;

import com.system.ordercontrol.domain.model.Ingredient;
import com.system.ordercontrol.domain.model.Product;
import com.system.ordercontrol.ingredients.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final IngredientRepository ingredientsRepository;
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository, IngredientRepository ingredientsRepository) {
        this.productRepository = productRepository;
        this.ingredientsRepository = ingredientsRepository;
    }

    public void upsert(Product product) {
        Set<String> ingredients =
                product.getIngredients()
                        .stream()
                        .map(Ingredient::getSlug)
                        .collect(Collectors.toSet());
        Iterable<Ingredient> results = ingredientsRepository.findBySlugIn(ingredients);
        System.out.println(results);
        productRepository.save(product);
    }

    public Optional<Product> get(UUID id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }
}

