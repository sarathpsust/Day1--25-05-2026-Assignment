package com.ecommerce;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CartProcessingEngine {

    private static List<Product> removeOutOfStockProducts(List<Product> list) {
        return list.stream()
                .filter(Product::isInStock)
                .toList();
    }

    private static List<Product> applyDiscountOnProducts(List<Product> list) {
        return list.stream()
                .map(p -> new Product(
                        p.getProductId(),
                        p.getName(),
                        p.getPrice() - (p.getPrice() * p.getDiscountPercentage() / 100),
                        p.isInStock(),
                        p.getDiscountPercentage(),
                        p.getProductDescription()
                )).toList();
    }

    private static Optional<Product> findMostExpensiveProduct(List<Product> list) {
        return list.stream()
                .max(Comparator.comparing(Product::getPrice));
    }

    private static List<Product> sortProductsByPrice(List<Product> list) {
        return list.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .toList();
    }

    private static List<Product> handleNullDescUsingOptional(List<Product> list) {
        return list.stream()
                .map(p -> new Product(
                        p.getProductId(),
                        p.getName(),
                        p.getPrice(),
                        p.isInStock(),
                        p.getDiscountPercentage(),
                        Optional.ofNullable(p.getProductDescription())
                                .orElse("No Description Available")
                )).toList();
    }

    private static Double addGSTCouponAndDeliveryCharges(List<Product> list) {
        double finalAmount = list.stream()
                .filter(Product::isInStock)
                .map(p -> new Product(
                        p.getProductId(),
                        p.getName(),
                        p.getPrice() - (p.getPrice() * p.getDiscountPercentage() / 100),
                        p.isInStock(),
                        p.getDiscountPercentage(),
                        Optional.ofNullable(p.getProductDescription())
                                .orElse("No Description Available")
                ))
                .mapToDouble(Product::getPrice)
                .sum();

        finalAmount = finalAmount - (finalAmount * 10 / 100); // coupon
        finalAmount = finalAmount + (finalAmount * 18 / 100); // GST
        return finalAmount = finalAmount + 100; // delivery
    }

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product(101, "Laptop", 75000.0, true, 10.0, ""),
                new Product(102, "Mobile", 35000.0, true, 15.0, ""),
                new Product(103, "Headphones", 2500.0, false, 5.0, ""),
                new Product(104, "Keyboard", 1800.0, true, 12.0, null),
                new Product(105, "Mouse", 900.0, true, 8.0, null),
                new Product(106, "Monitor", 15000.0, false, 20.0, ""),
                new Product(107, "Tablet", 28000.0, true, 18.0, null),
                new Product(108, "Smart Watch", 12000.0, true, 25.0, ""),
                new Product(109, "Speaker", 4500.0, false, 7.0, ""),
                new Product(110, "Power Bank", 2000.0, true, 10.0, null)
        );

        removeOutOfStockProducts(products).forEach(System.out::println);
        System.out.println();

        applyDiscountOnProducts(products).forEach(System.out::println);
        System.out.println();

        System.out.println("The most expensive product is: " + findMostExpensiveProduct(products));
        System.out.println();

        sortProductsByPrice(products).forEach(System.out::println);
        System.out.println();

        handleNullDescUsingOptional(products).forEach(System.out::println);
        System.out.println();

        System.out.println(addGSTCouponAndDeliveryCharges(products));
        System.out.println();
    }
}
