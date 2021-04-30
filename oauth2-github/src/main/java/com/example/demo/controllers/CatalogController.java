package com.example.demo.controllers;

import java.security.Principal;

import javax.annotation.security.RolesAllowed;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CatalogController {

	
	
	@GetMapping(path = "/")
	public String home() {
		
		return "Home Page";
	}

	@GetMapping(path = "/laptop")
	@RolesAllowed(value = "ROLE_ADMIN")
    public String electoronics(Principal principal) {
		
		System.out.println(principal);
		return "Popular Laptops";
	}
	
}
