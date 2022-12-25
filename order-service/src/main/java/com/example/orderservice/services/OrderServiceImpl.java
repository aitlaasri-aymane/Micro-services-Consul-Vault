package com.example.orderservice.services;

import com.example.orderservice.entities.Order;
import com.example.orderservice.feign.CustomerService;
import com.example.orderservice.feign.ProductService;
import com.example.orderservice.repositories.OrderRepo;
import com.example.orderservice.repositories.ProductItemRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private CustomerService customerService;
    private ProductService productService;
    private ProductItemRepo productItemRepo;
    private OrderRepo orderRepo;

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(()->new RuntimeException("Order not found"));
        order.setCustomer(customerService.getCustomerById(order.getCustomerId()));
        order.getProducts().forEach(productItem -> {
            productItem.setProduct(productService.getProductById(productItem.getProductID()));
        });
        return order;
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orders = orderRepo.findAll();
        orders.forEach(order -> {
            order.setCustomer(customerService.getCustomerById(order.getCustomerId()));
            order.getProducts().forEach(productItem -> {
                productItem.setProduct(productService.getProductById(productItem.getProductID()));
            });
        });
        return orders;
    }
}
