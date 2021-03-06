package com.example.demo.filters;

import java.net.URI;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class MyPreFilter extends AbstractGatewayFilterFactory<MyPreFilter.Config> {

	static class Config{
		
	}

	
	public MyPreFilter() {
		super(Config.class);
	}


	@Override
	public GatewayFilter apply(Config config) {
		return (exchange,chain) ->{
			
			  ServerHttpRequest request = exchange.getRequest();

			   
			            System.out.println("PRE FILTER =:"+request);
			            
			            return chain.filter(exchange.mutate().build());
			     
		};
	}
}
