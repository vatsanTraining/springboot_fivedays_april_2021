package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Customer;
import com.example.demo.repos.CustomerRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer Management",version = "1.0"))
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

		
	@Bean
	public CommandLineRunner runner() {
		
		
		return new CommandLineRunner() {
			
			@Autowired
			CustomerRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Customer(101,"ramesh","ram@abc.com"));
				repo.save(new Customer(102,"rajesh","raj@abc.com"));

			}
		};
	}
}
