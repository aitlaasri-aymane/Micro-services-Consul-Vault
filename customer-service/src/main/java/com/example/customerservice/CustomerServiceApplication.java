package com.example.customerservice;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.stream.Stream;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepo customerRepo, RepositoryRestConfiguration cofiguration){
		return args -> {
			cofiguration.exposeIdsFor(Customer.class);
			Stream.of("Aymane","Imad","Kahlid","Mehdi").forEach(name->{
				Customer customer = Customer.builder()
						.name(name)
						.email(name+"gmail.com")
						.build();
				Customer savedCustomer = customerRepo.save(customer);
				System.out.println(savedCustomer);
			});
		};
	}
}
