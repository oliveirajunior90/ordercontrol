package com.system.ordercontrol.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "quantity_in_stock")
    @JsonProperty("quantity_in_stock")
    private double quantityInStock;

    private String unity;

    private String slug;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public String getUnity() {
        return unity;
    }

    public void setQuantityInStock(double quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getSlug() {
        return slug;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingredient ingredient = (Ingredient) obj;
        return Double.compare(ingredient.quantityInStock, quantityInStock) == 0 &&
                id.equals(ingredient.id) &&
                name.equals(ingredient.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantityInStock);
    }
}
