package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.example.demo.model.Customer;

import lombok.val;

@SpringBootApplication
public class UsingProfilesApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=SpringApplication.run(UsingProfilesApplication.class, args);
	
	
	System.out.println("USING Profiles :="+ctx.getBean("magesh",Customer.class));
	
	
	ctx.close();
	}

	
	@Bean
	@Profile(value = "dev")
	public Customer ramesh() {
		
		return new Customer(101, "Devloper Ramesh", "ram@abc.com");
	}
	
	
	@Bean
	@Profile(value = "prod")
	public Customer suresh() {
		
		return new Customer(102, "Admin Suresh", "sur@abc.com");
	}

	@Bean
	@ConfigurationProperties(prefix = "com.training.custom")
	@Profile(value = "prod")
	public Customer magesh() { 

		return new Customer(101,"magesh","mag@abc.com");
	}


}
