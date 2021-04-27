package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

import com.example.demo.model.Customer;
import com.example.demo.utils.MyConditional;

@SpringBootApplication
public class ExploreAutoconfigureApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(ExploreAutoconfigureApplication.class, args);
	
	
	//System.out.println(ctx.getBean("manish",Customer.class));
	
	
	System.out.println(ctx.getBean(Customer.class));
	
	}

	
	@Bean
//	@ConditionalOnProperty(name = "com.example.demo.myprops" ,havingValue = "example")
//	@ConditionalOnProperty(name = "com.example.demo.myprops" ,havingValue = "lab")
	
	@Conditional(MyConditional.class)
	public Customer manish() {
		
		return new Customer(101,"Manish","manish@abc.com");
	}
	
	@Bean
	public Customer sawant() {
		
		return new Customer(102,"Sawant","sawant@abc.com");
	}
	
}
