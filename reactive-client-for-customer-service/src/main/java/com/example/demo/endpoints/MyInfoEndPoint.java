package com.example.demo.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
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
		      
		      response.put("beanCount",beanCount);
		      response.put("Startup", startUpDate);
		      
		       builder.withDetails(response);
	}

}
