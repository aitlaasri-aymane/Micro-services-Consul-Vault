package com.example.orderservice.entities;

import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.models.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @JsonIgnore
    private Long customerId;
    @Transient
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> products = new java.util.ArrayList<>();
}
