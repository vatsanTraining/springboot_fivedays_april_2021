package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
@RestController
public class OrderController {

	
	@GetMapping(path = "/orders/pending")
	@RolesAllowed(value = {"ROLE_ADMIN"})
	public List<String>  pendingOrderList() {
		
		return Arrays.asList("mrf","ceat","bridgestone");
		
	}
	
	@GetMapping(path = "/orders/finished")
	@PermitAll
	public List<String> completedOrderList(){
		
		return Arrays.asList("tata","maruti","ford");
		
	}
	
	
}
