package com.banking.auth.service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;

public interface CustomerService {
   
	Customers registerCustomer (Customers customer);

	Customers findCustomerByEmail(String email);
	
	AccountDetails addAccountDetails(AccountDetails accountDetails);
}
