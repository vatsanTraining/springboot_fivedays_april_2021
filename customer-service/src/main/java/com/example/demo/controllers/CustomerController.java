package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.demo.model.*;
import com.example.demo.service.CustomerService;
import com.example.demo.utils.ProjectNameAndEmail;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api/v1")
@Slf4j
public class CustomerController {

	@Value("${server.port}")
	private String port;
	
	private CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
		log.info("Customer Controller called");
	}
	
	@Operation(description = "This endpoint retrieves the List of Customer from april month customer table")
	@GetMapping(path = "/customers",produces = "application/json")
	public List<Customer> findAll(){
		
		log.info("find all customers called");
		return this.service.getAllCustomers();
	}
	
	@PostMapping(path = "/customers", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer entity) {
		
		Customer added = this.service.addCustomer(entity);
		
		return new ResponseEntity<Customer>(added,HttpStatus.CREATED);
	}
	
	
	@PostMapping(path = "/form/customers", produces = "application/json", 
			 consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Customer> addCustomerUsingForm(@ModelAttribute Customer entity) {
		
		Customer added = this.service.addCustomer(entity);
		
		return new ResponseEntity<Customer>(added,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/customers/{id}",produces = "application/json")
	public Customer getCustomerById(@PathVariable("id") int id)
	{
		
		Customer found = null;
		 Optional<Customer> resp = this.service.getCustomerById(id);
				 
				 if(resp.isPresent()) {
					 found = resp.get();
					 found.setEmail(found.getEmail() +"="+port);
				 } else {
					
					 new RuntimeException("Customer Id Not Found");
				 }
				  
				 return found;
	}
	
//	@GetMapping(path = "/customers/{id}",produces = "application/json")
//	public Customer getCustomerById(@PathVariable("id") int id)
//	{
//		
//		 return this.service.getCustomerById(id).
//				  orElseThrow(()-> new RuntimeException("Customer Id Not Found"));
//	}
	
	
	
	@GetMapping(path = "/customers/select/{id}",produces = "application/json")
	public List<ProjectNameAndEmail> getNameAndEmail(@PathVariable("id") int id)
	{
		
		 return this.service.findSelectedColumns(id);
		 
	}
	
	@PutMapping(path = "/customers",produces = "application/json", consumes = "application/json")
	public Customer updateDateCustomer(@RequestBody Customer customer) {
		
		return this.service.update(customer);
	}
	
	
	
	@DeleteMapping(path = "/customers",produces = "application/json", consumes = "application/json")
	public Customer removeCustomer(@RequestBody Customer customer) {
		
		return this.service.removeCustomer(customer).orElseThrow(()->new RuntimeException("Customer Not Found -Not Delete"));
		
	}
	
	@GetMapping(path = "/srch/customers/{name}",produces = "application/json")
	public List<Customer> findByName(@PathVariable("name") String name){
		
		return this.service.findByName(name);
	}
}
