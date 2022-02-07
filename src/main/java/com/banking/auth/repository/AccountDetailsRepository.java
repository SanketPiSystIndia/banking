package com.banking.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.AccountDetails;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long>{

	
	@Query("SELECT a FROM AccountDetails a WHERE a.accountNumber = ?1")
	AccountDetails fetchAccountDetails(String accountNumber);

	
	@Modifying
	@Transactional
	@Query("UPDATE AccountDetails a SET a.accountBalance=?1,a.updatedAt=?2 WHERE a.accountNumber=?3")
	int updateAccountBalance(long accountBalance,String date,String accountNumber);


	@Modifying
	@Transactional
	@Query("UPDATE Customers c SET c.password=?1 WHERE c.email=?2")
	int resetPassword(String pasword, String email);
	
	

}
