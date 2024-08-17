package com.system.ordercontrol.domain.model;

import java.util.Objects;

public class OrderItem {
    private Long id;
    private Product product;
    private int quantity;

    public OrderItem(Long id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
                Objects.equals(id, orderItem.id) &&
                Objects.equals(product, orderItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
