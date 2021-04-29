package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.health.HealthContributorAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveClientController {

	@Autowired
	private WebClient client;
	
	public static final String BASEURL ="lb://CUSTOMER-SERVICE/api/v1/customers/{id}";
	@GetMapping(path = "/client/customers/{srchId}")
	public Mono<String> getAllCustomers(@PathVariable("srchId") int srchId){
		
		return client
				.get()
				  .uri(BASEURL,srchId)
				   .retrieve()
				     .bodyToMono(String.class);
	}
}
