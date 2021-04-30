package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.client.WebClientResponseException;



@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = WebClientResponseException.class)
	public ErrorDetails handleWebClientResponseException(WebClientResponseException ex) {
	    	  
		ErrorDetails details = new ErrorDetails(ex.getRawStatusCode(),ex.getResponseBodyAsString());

		return details;
		//return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());
	}
	

}
