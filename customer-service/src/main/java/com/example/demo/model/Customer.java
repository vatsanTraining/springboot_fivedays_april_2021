package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@AllArgsConstructor

@Table(name = "april_customer")
@Entity
public class Customer {

	@Id
	int id;
	String name;
	String email;
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	
	
}
