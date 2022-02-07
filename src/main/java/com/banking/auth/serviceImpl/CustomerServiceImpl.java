package com.banking.auth.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.repository.AccountDetailsRepository;
import com.banking.auth.repository.CustomerRepository;
import com.banking.auth.service.CustomerService;
import com.banking.auth.util.AccountNumberGenerator;


@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AccountDetailsRepository accountDetailsRepository;
	
	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	
	@Autowired
	PasswordEncoder encoder;
	
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Override
	public Customers registerCustomer(Customers customer) {
		// TODO Auto-generated method stub
		
		String currentTime = dateFormat.format(new Date());
		
		String accountNumber = accountNumberGenerator.generateAccountNumber()+""+accountNumberGenerator.generateAccountNumber();
		
		customer.setAccountNumber(accountNumber);
		customer.setPassword(encoder.encode(customer.getPassword()));
		customer.setTransactionPin(""+accountNumberGenerator.generateTransactionPin());
		customer.setStatus("1");
		
		
		customer.setCreatedAt(currentTime);
		customer.setUpdatedAt(currentTime);
		
		return customerRepository.save(customer);
	}

	@Override
	public Customers findCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findCustomerByEmail(email);
	}

	@Override
	public AccountDetails addAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}

}
