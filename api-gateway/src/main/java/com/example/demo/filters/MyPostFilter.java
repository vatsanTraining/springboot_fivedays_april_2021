package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import com.example.demo.filters.MyPreFilter.Config;

import reactor.core.publisher.Mono;

@Component
public class MyPostFilter extends AbstractGatewayFilterFactory<MyPostFilter.Config> {

static class Config{
		
	}


public MyPostFilter() {
	super(Config.class);
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
