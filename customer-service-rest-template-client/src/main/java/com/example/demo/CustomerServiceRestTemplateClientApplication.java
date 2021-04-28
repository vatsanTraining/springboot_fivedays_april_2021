package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.CustomerDTO;

@SpringBootApplication
public class CustomerServiceRestTemplateClientApplication {

	
	
	public static void main(String[] args) {
	ConfigurableApplicationContext	ctx=SpringApplication.run(CustomerServiceRestTemplateClientApplication.class, args);
		
	    RestTemplate template = ctx.getBean(RestTemplate.class);
	    
	    
//	    String  stringResponse = 
//	    	    template.getForObject("http://localhost:8080/api/v1/customers", String.class); 

	  	  
	    ResponseEntity<CustomerDTO[]> responseEntity = 
	    	    template.getForEntity("http://localhost:8080/api/v1/customers", CustomerDTO[].class); 

	    	  CustomerDTO[] array = responseEntity.getBody();

	    	  List<CustomerDTO> response = Arrays.asList(array);
	    	  
	    	  
	    	  response.forEach(System.out::println);

	    	  
	    	    ctx.close();
	
	}

	
	@Bean
	public RestTemplate template() {
		
		return new RestTemplate();
	}
}



