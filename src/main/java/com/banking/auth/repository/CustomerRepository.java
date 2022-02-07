package com.banking.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.Customers;

@Repository 
public interface CustomerRepository extends JpaRepository<Customers, Long>{
	
	@Query("SELECT c FROM Customers c  WHERE c.email= ?1" )
	Customers findCustomerByEmail(String email);



}
