package com.banking.auth.service;

import com.banking.auth.entities.AccountDetails;

public interface AccountSerive {

	AccountDetails fetchAccountDetails(String accountNumber);

	int updateAccountBalance(long accountBalance,String date, String accountNumber );

	
	

	

}
