package com.banking.auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.repository.AccountDetailsRepository;
import com.banking.auth.service.AccountSerive;

@Service
public class AccountServiceImpl implements AccountSerive{
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Override
	public AccountDetails fetchAccountDetails(String accountNumber) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.fetchAccountDetails(accountNumber);
	}

	@Override
	public int updateAccountBalance(long accountBalance,String date, String accountNumber) {
		// TODO Auto-generated method stub

		
		return accountDetailsRepository.updateAccountBalance(accountBalance,date,accountNumber);
	}

	

	

}
