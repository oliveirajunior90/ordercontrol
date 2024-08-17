package com.system.ordercontrol.product;

import com.system.ordercontrol.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void upsert(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> get(UUID id) {
        return productRepository.findById(id);
    }

    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }
}

