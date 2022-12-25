package com.example.orderservice.models;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
