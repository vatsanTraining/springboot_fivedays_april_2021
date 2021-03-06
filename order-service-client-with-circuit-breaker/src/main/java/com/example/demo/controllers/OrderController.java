package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrderController {

	
	
	@Autowired
	private RestTemplate template;
	
	  @GetMapping("/order")
	    @ResponseStatus(HttpStatus.OK)
	    @CircuitBreaker(name="order-service", fallbackMethod = "orderFallback")
	    public ResponseEntity<String> createOrder(){
	        String response = template.getForObject("http://localhost:8081/order", String.class);
	        return new ResponseEntity<String>(response, HttpStatus.OK);
	    }
	  
	    public ResponseEntity<String> orderFallback(Exception e){
	        return new ResponseEntity<String>("Item service is down", HttpStatus.OK);

	    }
	}



