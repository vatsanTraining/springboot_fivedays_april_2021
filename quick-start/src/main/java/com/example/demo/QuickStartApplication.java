package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.example.demo.config.CustomConfig;
import com.example.demo.model.Customer;
import com.example.demo.model.Invoice;
import com.example.demo.model.OrderBook;
import com.example.demo.model.Product;

@SpringBootApplication
public class QuickStartApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx   =	
			SpringApplication.run(CustomConfig.class, args);
		
	   System.out.println(ctx.getClass().getName());
	   
	   Customer ramesh = ctx.getBean(Customer.class);
	   
	   System.out.println(ramesh);
	   
	   Product tv = ctx.getBean(Product.class);
	   
	   System.out.println(tv);
	                       
	   Invoice invoice1 = ctx.getBean("invoice1",Invoice.class);
	   
	   System.out.println(invoice1);
	    
	    Invoice invoice2 = ctx.getBean(args[1],Invoice.class);
		   
		   System.out.println(invoice2);
//		    
//		   
//		OrderBook orderBook = ctx.getBean(OrderBook.class);
//		
//		System.out.println(orderBook);
//		
//		System.out.println("IS Singleton=:"+ ctx.isSingleton("orderBook"));
//		System.out.println("IS Prototype=:"+ ctx.isPrototype("orderBook"));
	   ctx.close();
	
	}

//	@Bean
//	public Customer ramesh() {
//		
//		return new Customer(101,"Ramesh","ram@abc.com");
//		
//	}
//	
//	@Bean
//	public Product tv() {
//		
//		return new Product(101,"sony tv",2);
//			}
//	
//	@Bean
//	public Invoice invoice1() {
//		
//		return new Invoice(900, ramesh(), tv());
//	}
	
}
