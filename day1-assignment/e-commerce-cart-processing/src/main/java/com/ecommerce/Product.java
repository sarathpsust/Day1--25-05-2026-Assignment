package com.ecommerce;

public class Product {

    private int productId;

    private String name;

    private double price;

    private boolean inStock;

    private double discountPercentage;

    private String productDescription;

    public Product(int productId, String name, double price, boolean inStock, double discountPercentage, String productDescription) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.discountPercentage = discountPercentage;
        this.productDescription = productDescription;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                ", discountPercentage=" + discountPercentage +
                ", productDescription=" + productDescription +
                '}';
    }
}
