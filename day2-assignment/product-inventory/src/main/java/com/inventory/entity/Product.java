package com.inventory.entity;

public class Product {

    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    private String category;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }
}
