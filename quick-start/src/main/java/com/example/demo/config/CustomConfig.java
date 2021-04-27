package com.example.demo.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.Product;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","com.example.demo.config"})
public class CustomConfig {

	@Bean
	public Customer ramesh() {
		
		return new Customer(101,"Ramesh","ram@abc.com");
		
	}
	
	@Bean
	public Product tv() {
		
		return new Product(101,"sony tv",2);
			}
	
	@Bean
	public Invoice invoice1() {
		
		return new Invoice(900, ramesh(), tv());
	}

}
