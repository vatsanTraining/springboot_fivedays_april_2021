package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		
		auth.inMemoryAuthentication().withUser("india").password("{noop}india").roles("ADMIN")
		       .and().withUser("chennai").password("{noop}chennai").roles("GUEST");
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	
		//http.authorizeRequests().antMatchers("/orders/**").authenticated().and().formLogin();
		
		http.authorizeRequests().antMatchers("/orders/**").authenticated().and().httpBasic();
	}

	
	
}
