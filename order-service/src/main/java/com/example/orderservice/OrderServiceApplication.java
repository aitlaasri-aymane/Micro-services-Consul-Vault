package com.example.orderservice;

import com.example.orderservice.entities.Order;
import com.example.orderservice.entities.ProductItem;
import com.example.orderservice.enums.OrderStatus;
import com.example.orderservice.feign.CustomerService;
import com.example.orderservice.feign.ProductService;
import com.example.orderservice.models.Customer;
import com.example.orderservice.models.Product;
import com.example.orderservice.repositories.OrderRepo;
import com.example.orderservice.repositories.ProductItemRepo;
import feign.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	CommandLineRunner start(CustomerService customerService, ProductService productService, OrderRepo orderRepo, ProductItemRepo productItemRepo){
		return args -> {
			customerService.getAllCustomers(0,10).forEach(customer -> {
				Order order = Order.builder()
						.id(null)
						.createdAt(new Date())
						.customer(customer)
						.customerId(customer.getId())
						.orderStatus(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CANCELED)
						.products(null)
						.build();
				Order savedOrder = orderRepo.save(order);
				productService.getPageProducts(0,10).forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.order(savedOrder)
							.productID(product.getId())
							.quantity(product.getQuantity())
							.name(product.getName())
							.product(product)
							.price(product.getPrice())
							.build();
					productItemRepo.save(productItem);
				});
			});
		};
	}
}
