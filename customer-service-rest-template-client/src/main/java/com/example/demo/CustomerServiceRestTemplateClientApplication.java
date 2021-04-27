package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CustomerDTO;

@SpringBootApplication
public class CustomerServiceRestTemplateClientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(CustomerServiceRestTemplateClientApplication.class, args);
		
	    RestTemplate template = ctx.getBean(RestTemplate.class);
	    
	    
	    String resp = template.getForObject("http://localhost:8080/api/v1/customers",
	    		        String.class);
	    
	    System.out.println(resp);
	    
	    
//	    CustomerDTO dto = template.getForObject("http://localhost:8080/api/v1/customers",
//		        CustomerDTO.class);
//
//              System.out.println(dto.getCustList());

	}

	
	@Bean
	public RestTemplate template() {
		
		return new RestTemplate();
	}
}



