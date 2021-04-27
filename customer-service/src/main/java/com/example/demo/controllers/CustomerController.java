package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;
import com.example.demo.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/api/v1")
public class CustomerController {

	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@Operation(description = "This endpoint retrieves the List of Customer from april month customer table")
	@GetMapping(path = "/customers",produces = "application/json")
	public List<Customer> findAll(){
		
		return this.service.getAllCustomers();
	}
	
	@PostMapping(path = "/customers", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer entity) {
		
		Customer added = this.service.addCustomer(entity);
		
		return new ResponseEntity<Customer>(added,HttpStatus.CREATED);
	}
	
}
