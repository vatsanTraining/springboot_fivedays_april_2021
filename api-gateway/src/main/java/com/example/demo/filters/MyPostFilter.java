package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import reactor.core.publisher.Mono;

public class MyPostFilter extends AbstractGatewayFilterFactory<MyPostFilter.Config> {

static class Config{
		
	}

@Override
public GatewayFilter apply(Config config) {
	return (exchange, chain) -> {
        return chain.filter(exchange)
          .then(Mono.fromRunnable(() -> {
     System.out.println("Post Filter executed");
          }));
};
}
}
