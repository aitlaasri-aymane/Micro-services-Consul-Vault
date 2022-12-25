package com.example.orderservice.entities;

import com.example.orderservice.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private Order order;
    @JsonIgnore
    private Long productID;
    private String name;
    private double price;
    private int quantity;
    @Transient
    @JsonIgnore
    private Product product;
}