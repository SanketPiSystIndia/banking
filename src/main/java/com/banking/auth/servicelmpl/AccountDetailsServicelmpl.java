package com.banking.auth.servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.repository.AccountDetailsRepository;
import com.banking.auth.service.AccountDetailsService;

@Service
public class AccountDetailsServicelmpl implements AccountDetailsService  {
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Override
	public AccountDetails fetchAccountDetails(String accountNumber) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.fetchAccountDetails(accountNumber);
		
	}
	

	@Override
	public int updateAccountBalance(long accountBalance,String accountNumber) {
		
	
	
		// TODO Auto-generated method stub
		return accountDetailsRepository.updateAccountBalance(accountBalance,accountNumber);
	}


	@Override
	public AccountDetails addAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}


	@Override
	public int updateAccountBalance(long accountBalance, String accountNumber, String date) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	}


	
	




	


	






