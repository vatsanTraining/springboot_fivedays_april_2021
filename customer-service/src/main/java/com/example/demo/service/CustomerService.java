package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

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
	
	
	public Customer addCustomer(Customer entity) {
		
		return this.repo.save(entity);
		
	}
}
