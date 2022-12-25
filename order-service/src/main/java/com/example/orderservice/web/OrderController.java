package com.example.orderservice.web;

import com.example.orderservice.entities.Order;
import com.example.orderservice.services.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private IOrderService iOrderService;

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id){
        return iOrderService.getOrderById(id);
    }
    @GetMapping("/orders")
    public List<Order> getOrders(){
        return iOrderService.getOrders();
    }
}
