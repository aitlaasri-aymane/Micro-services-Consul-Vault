package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepo productRepo, RepositoryRestConfiguration cofiguration){
		return args -> {
			cofiguration.exposeIdsFor(Product.class);
			Stream.of("P1","P2","P3","P4").forEach(name->{
				Product product = Product.builder()
						.name(name)
						.price(new Random().nextDouble(10,1000))
						.quantity(new Random().nextInt(0,100))
						.build();
				Product savedProduct = productRepo.save(product);
				System.out.println(savedProduct);
			});
		};
	}
}
