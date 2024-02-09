package com.example.thymeleafformdemo;


public class Product {

    private Long id;
    private String description;
    private Double price;

    public Product(long l, String s, double v) {
        this.id = l;
        this.description = s;
        this.price = v;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
