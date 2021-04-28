package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import javax.persistence.Entity;

import com.example.demo.model.Customer;
import com.example.demo.repos.CustomerRepository;

@Service
public class CustomerService {

	
	private CustomerRepository repo;

	@Autowired
	public CustomerService(CustomerRepository repo) {
		super();
		this.repo = repo;
		
		System.out.println("Repository Reference:="+ repo.getClass().getName());
	}
	
	public List<Customer> getAllCustomers(){
		
		return this.repo.findAll();
	}
	
	public Optional<Customer> getCustomerById(int id) {
		
	
		 return this.repo.findById(id);
	}
	
	public Customer addCustomer(Customer entity) {
		
		return this.repo.save(entity);
		
	}
	
	public Customer update(Customer customer) {
		
		return this.repo.save(customer);
	}
	
	public Optional<Customer> removeCustomer(Customer customer){
		
		Optional<Customer> response = Optional.empty();
		
		if(this.repo.existsById(customer.getId())) {
			
			   this.repo.delete(customer);
			   
			   response = Optional.of(customer);
		}
		
		return response;
	}
	
	public List<Customer> findByName(String srchName){
		
		 return this.repo.findByName(srchName);
		
	}
	
	
}
