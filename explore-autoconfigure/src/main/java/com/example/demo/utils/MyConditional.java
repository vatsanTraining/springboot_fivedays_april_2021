package com.example.demo.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@ConfigurationProperties(prefix = "com.training")
public class MyConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

		String value =context.getEnvironment().getProperty("os.name");
		
		metadata.getAnnotations().forEach(System.out::println);
		
		if(value.equalsIgnoreCase("Windows 10")) {
			return true;
		} else {
				
		return false;
	}
	}
}
