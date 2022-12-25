package com.example.inventoryservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "product",types = Product.class) // ?projection=product
public interface ProductProjection {
    double getPrice();
}
