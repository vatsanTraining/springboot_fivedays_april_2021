package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	private RestTemplate template;

	public ClientController(RestTemplate template) {
		super();
		this.template = template;
	}
	
	
	@GetMapping(path = "/client")
	public String invokeCustomer() {
		
		  String baseURL = "http://CUSTOMER-SERVICE/";
		  String srchURL = baseURL+"api/v1/customers";
		  
           return  this.template.getForObject(srchURL,String.class);
		
	}
	
}
