package com.example.orderservice.feign;

import com.example.orderservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface ProductService {
    @GetMapping("/products")
    PagedModel<Product> getPageProducts(@RequestParam int page, @RequestParam int size);
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
