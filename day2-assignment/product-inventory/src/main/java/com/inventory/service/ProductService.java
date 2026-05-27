package com.inventory.service;

package com.example.productinventory.service;

import com.example.productinventory.entity.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<Long, Product> productDB = new HashMap<>();

    public String addProduct(Product product) {

        if (product.getPrice() < 0) {
            return "Invalid Price. Price cannot be negative.";
        }

        if (product.getQuantity() < 0) {
            return "Invalid Quantity. Quantity cannot be negative.";
        }

        if (productDB.containsKey(product.getId())) {
            return "Product with this ID already exists.";
        }

        productDB.put(product.getId(), product);

        return "Product added successfully.";
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productDB.values());
    }

    public String updateProductQuantity(Long id, Integer quantity) {

        Product existingProduct = productDB.get(id);

        if (existingProduct == null) {
            return "Product not found.";
        }

        if (quantity < 0) {
            return "Invalid Quantity. Quantity cannot be negative.";
        }

        existingProduct.setQuantity(quantity);

        return "Product quantity updated successfully.";
    }

    public String deleteProduct(Long id) {

        if (!productDB.containsKey(id)) {
            return "Product not found.";
        }

        productDB.remove(id);

        return "Product deleted successfully.";
    }
}
