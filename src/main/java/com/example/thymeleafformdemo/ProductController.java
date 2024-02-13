package com.example.thymeleafformdemo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private final List<Product> products = new ArrayList<>(); // Shared ArrayList
    @GetMapping("/products")
    public List<Product> getProducts() {
        //List<Product> products = new ArrayList<>();
        //products.add(new Product(1L, "Product 1", 19.99));
        //products.add(new Product(2L, "Product 2", 24.95));
        //products.add(new Product(3L, "Product 3", 14.50));

        //for (int i = 0; i < products.size(); i++) {
        //    Product product = products.get(i);
        //    System.out.println("Product ID: " + product.getId());
        //    System.out.println("Description: " + product.getDescription());
        //    System.out.println("Price: $" + product.getPrice());
        //    System.out.println("--------------------"); // Optional separator
        //}

        return products;
    }

    @PostMapping("/create-product")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
        products.add(product);
        for (int i = 0; i < products.size(); i++) {
            Product prod = products.get(i);
            System.out.println("Product ID: " + prod.getId());
            System.out.println("Description: " + prod.getDescription());
            System.out.println("Price: $" + prod.getPrice());
            System.out.println("--------------------"); // Optional separator
        }

        return ResponseEntity.ok().build();
    }

}