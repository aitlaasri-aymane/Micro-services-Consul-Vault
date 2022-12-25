package com.example.orderservice.services;

import com.example.orderservice.entities.Order;

import java.util.List;

public interface IOrderService {
    Order getOrderById(Long id);
    List<Order> getOrders();
}
