package com.banking.auth.util;

import org.springframework.stereotype.Service;

import com.banking.auth.customrequest.CustomRequestForMoneyTransfer;
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
		
		if(customer.getEmail().matches(emailRegex)== false) {
			
			throw new InvalidRequestException("Email in the correct way");
	}
		String mobileRegex= "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}$";
		if(customer.getMobile().matches(mobileRegex)== false) 
			 
			throw new InvalidRequestException("mobile in the correct way");
}

	public void loginCustomers(Customers customer) {
		// TODO Auto-generated method stub
		if(customer.getFirstName().equals("")) {
			throw new InvalidRequestException("Firstname should not be null");
			
		}
		String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
		if(customer.getEmail().matches(emailRegex)== false) {
			
			throw new InvalidRequestException("Email in the correct way");
	}
		String mobileRegex= "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6789]\\d{9}$";
		if(customer.getMobile().matches(mobileRegex)== false) 
			 
			throw new InvalidRequestException("mobile in the correct way");
}


	public void addBalanceValidations(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		if(accountDetails.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Account Number not be Empty");
			
		}
		if(accountDetails.getAccountBalance() <=0) {
			throw new InvalidRequestException("Account Number not be zero or negative");
	}
	
	}

	public void moneyTransferValidations(CustomRequestForMoneyTransfer transfermoney) {
		// TODO Auto-generated method stub
		if(transfermoney.getAccountNumber().equals("")) {
			throw new InvalidRequestException("Account Number not be Empty");
			
		}
		
		if(transfermoney.getUserAccountNumber().equals("")) {
			throw new InvalidRequestException("user Account Number not be Empty");
			
	
}
		if(transfermoney.getAmount()<=0) {
			throw new InvalidRequestException("Enter valid amount");
		}
	}
}
