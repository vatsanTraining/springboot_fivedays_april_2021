package com.example.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.*;
@Component
public class MyInfoEndPoint implements InfoContributor {

	
	@Autowired
	ConfigurableApplicationContext ctx;
	
	@Override
	public void contribute(Info.Builder builder) {

		
		HashMap<String, Object> response = new HashMap<>();
		
		      int beanCount =ctx.getBeanDefinitionCount();
		      long startUpDate =      ctx.getStartupDate();
		      
		      Date date = new Date(startUpDate);
		      
		     LocalDateTime time= LocalDateTime.ofInstant(date.toInstant(),ZonedDateTime.now().getZone());
		      
		      response.put("beanCount",beanCount);
		      response.put("Startup", time);
		      
		       builder.withDetails(response);
	}

}
