package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ClientController {

	
	private RestTemplate template;

	  String baseURL = "http://CUSTOMER-SERVICE/";

	public ClientController(RestTemplate template) {
		super();
		this.template = template;
		
		log.info("Rest Template client called");
	}
	
	
	@GetMapping(path = "/client")
	public String invokeCustomer() {
		
		log.info("Invoke customer called");
		  String srchURL = baseURL+"api/v1/customers";
		  
           return  this.template.getForObject(srchURL,String.class);
		
	}
	
}
