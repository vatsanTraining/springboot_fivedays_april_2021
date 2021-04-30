package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@RestController
public class ClientController {

	
	@Autowired
	WebClient client;
	
	
	@GetMapping(path = "/client")
	public Flux<String> getAll(){
		
		 return client.get().uri("http://localhost:8080/orders/pending")
		 .headers(headers -> headers.setBasicAuth("chennai","chennai"))
		 .retrieve().bodyToFlux(String.class);
		
	}
}
