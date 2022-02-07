package com.banking.auth.util;

import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.exception.InvalidRequestException;

@Service
public class Validations {

	public void registerCustomer(Customers customer) {
		
		if(customer.getFirstName().equals("")) {
			throw new InvalidRequestException("Firstname should not be null");
			
		}
		
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if(customer.getEmail().matches(emailRegex) == false) {
			
			throw new InvalidRequestException("Email Id should be in proper format");
		}
		
	}

	public void loginCustomer(Customers customer) {
		
		if(customer.getEmail().equals("")) {
			throw new InvalidRequestException("Email Id should not be empty");
		}
		
		if(customer.getPassword().equals("")) {
			throw new InvalidRequestException("Password should not be empty");
		}
		
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if(customer.getEmail().matches(emailRegex) == false) {
			
			throw new InvalidRequestException("Email Id should be in proper format");
		}
		
		
		
	}

	public void addBalanceValidations(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		
		if(accountDetails.getAccountNumber().equals("")) {
			
			throw new InvalidRequestException("Account Number should not be empty");
		}
		
		if(accountDetails.getAccountBalance() <= 0) {
			
			throw new InvalidRequestException("Account Number should not be zero or negative");
		}
		
	}

	

}
