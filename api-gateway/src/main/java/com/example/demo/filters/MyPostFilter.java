package com.example.demo.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

public class MyPostFilter extends AbstractGatewayFilterFactory<MyPostFilter.Config> {

static class Config{
		
	}

@Override
public GatewayFilter apply(Config config) {
	// TODO Auto-generated method stub
	return null;
}
}
