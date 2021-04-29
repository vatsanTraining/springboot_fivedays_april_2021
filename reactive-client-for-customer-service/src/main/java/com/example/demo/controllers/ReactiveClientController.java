package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveClientController {

	
	@Autowired
	private WebClient client;
	
	public static final String BASEURL ="lb://CUSTOMER-SERVICE/api/v1/customers/";
	@GetMapping(path = "/client/customers")
	public Flux<String> getAllCustomers(){
		
		return client
				.get()
				  .uri(BASEURL)
				   .retrieve()
				     .bodyToFlux(String.class);
	}
}
