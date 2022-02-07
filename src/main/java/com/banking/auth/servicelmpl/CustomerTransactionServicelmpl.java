package com.banking.auth.servicelmpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.CustomerTransactions;
import com.banking.auth.repository.CustomerTransactionRepository;
import com.banking.auth.service.CustomerTransactionService;

@Service
public class CustomerTransactionServicelmpl implements CustomerTransactionService{
    
	@Autowired
	CustomerTransactionRepository customerTransactionRepository ;
	
	
	
	
	@Override
	
	public CustomerTransactions saveTransaction(CustomerTransactions sendersTransaction) {
		// TODO Auto-generated method stub
		 return  customerTransactionRepository.save(null);
	}

	
	

	}


