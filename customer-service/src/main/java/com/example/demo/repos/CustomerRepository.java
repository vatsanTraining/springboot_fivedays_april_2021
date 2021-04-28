package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import java.util.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
  List<Customer> findByName(String srchName);
  
  
//	  @Query(value ="select com.example.model.Customer(c.name,c.email) from Customer c where c.id=?1")
//	  Customer findSelctiveColumn(String srchName);

    @Query(value = "update Customer set email = :updateMail where id=:srchId")
	@Modifying
	@Transactional
	public int updateMail(@Param("srchId") int id,@Param("updateMail") String updateMail);
	
  
  
}
