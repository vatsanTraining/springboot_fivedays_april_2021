package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

	
	
	@GetMapping(path = "/")
	public String home() {
		
		return "Home Page";
	}

	@GetMapping(path = "/laptop")
    public String electoronics() {
		
		return "Popular Laptops";
	}
	
}
