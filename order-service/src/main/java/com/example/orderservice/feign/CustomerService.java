package com.example.orderservice.feign;

import com.example.orderservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "customer-service")
public interface CustomerService {
    @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable Long id);
    @GetMapping("/customers")
    PagedModel<Customer> getAllCustomers(@RequestParam int page, @RequestParam int size);
}
