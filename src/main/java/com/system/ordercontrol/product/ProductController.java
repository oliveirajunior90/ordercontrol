package com.system.ordercontrol.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.ordercontrol.domain.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value="/api/v1/product")
public class ProductController {

    ProductService productService;

    @GetMapping("/healthcheck")
    public String healthcheck() {
        return "ok";
    }

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    public void create(Product product) {
        productService.upsert(product);
    }

    public void update(Product product) {
        productService.upsert(product);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Product>> get(@PathVariable UUID id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @GetMapping("/get")
    public ResponseEntity<Iterable<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

}
