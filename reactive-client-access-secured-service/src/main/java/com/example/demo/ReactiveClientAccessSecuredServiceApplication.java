package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveClientAccessSecuredServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveClientAccessSecuredServiceApplication.class, args);
	}

	@Bean
	public WebClient.Builder builder(){
		
		return WebClient.builder();
	}
	
	@Bean
	public WebClient client(WebClient.Builder builderRef) {
		
		return builderRef.build();
	}
}
