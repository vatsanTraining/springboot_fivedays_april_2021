package com.example.demo;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

@WebEndpoint(id = "custom")
@Component
public class CustomEndPoint {

	
	String info ="custom Endpoint";
	
	@ReadOperation
	public String releaseInfo() {
	   return this.info+"version10";
	  }
	
	
	@WriteOperation
	public String updateTag(@Selector String tag) {
	   return this.info+tag;
	  }
	

}
