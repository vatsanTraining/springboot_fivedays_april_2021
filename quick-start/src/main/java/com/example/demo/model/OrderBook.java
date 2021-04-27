package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Data
@Component
//@Lazy
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class OrderBook {

	
	
	int id;
	
	/**
	 *  When Using @AutoWired on field 
	 *   
	 *   Case - 1 => No Bean  => 
	 *        -> Can Create a Bean with @Bean
	 *        -> Can Use @Component on the Bean class
	 *        -> can use @AutoWire(required =false)
	 *   
	 *   Case - 2 => Only One Bean
	 *       -> No problem can use @AutoWired
	 *   
	 *   Case -3 => More than One Bean
	 *         -> UniqueBean Exception will be thrown
	 *        -> @Qualifier and give the name of the Bean
	 */
	
	@Autowired()
    @Qualifier("invoice1")
	private Invoice invoice;
	
	
}
