package com.banking.auth.controller;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customrequest.CustomRequestForMoneyTransfer;
import com.banking.auth.customresponse.CustomerResponseForUser;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.CustomerTransactions;
import com.banking.auth.service.AccountDetailsService;
import com.banking.auth.service.CustomerTransactionService;
import com.banking.auth.util.Validations;

@RestController 
@RequestMapping("/customer/transactions")
public class CustomerTranscationController {
	
	
	@Autowired
	AccountDetailsService  accountDetailsService; 
	
	@Autowired
	CustomerTransactionService customerTransactionsService;
	
	@Autowired 
	Validations validations;
	
	@PostMapping("/addBalance")
	public ResponseEntity<Object>addBalance(@RequestBody AccountDetails accountDetails) {
		
		validations.addBalanceValidations(accountDetails);
		
		AccountDetails fetchAccountDetails = accountDetailsService.fetchAccountDetails(accountDetails.getAccountNumber());
		if(fetchAccountDetails!=null) {
			
			long accountBalance = fetchAccountDetails.getAccountBalance()+ accountDetails.getAccountBalance();
			
			accountDetailsService.updateAccountBalance(accountDetails.getAccountBalance(),accountDetails.getAccountNumber());
			
			CustomerResponseForUser   responseStructure = new CustomerResponseForUser(new Date(),"Account Balance Updated Suceesfully","409");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
	
		}else {
	
			CustomerResponseForUser   responseStructure = new CustomerResponseForUser(new Date(),"Invalid Account Number","409");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
		
		}
	}

		
	@PostMapping("/moneyTransfer")

	public ResponseEntity<Object> transferMoney(@RequestBody CustomRequestForMoneyTransfer moneyTransfer){

		

		AccountDetails fetchedAccountDetails = accountDetailsService.fetchAccountDetails(moneyTransfer.getAccountNumber());

		

		if(fetchedAccountDetails != null) {

			

			AccountDetails fetchReceiversAccount = accountDetailsService.fetchAccountDetails(moneyTransfer.getUserAccountNumber());

			

			if(fetchReceiversAccount != null) {

				long sendersAccountBalance = fetchedAccountDetails.getAccountBalance() - moneyTransfer.getAmount();

				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

				String date = ""+dateFormat.format(new Date()) ;
				accountDetailsService.updateAccountBalance(sendersAccountBalance,date,fetchedAccountDetails.getAccountNumber());
				CustomerTransactions sendersTransaction = new CustomerTransactions();

				sendersTransaction.setAccountNumber(fetchedAccountDetails.getAccountNumber());

				sendersTransaction.setAmount(moneyTransfer.getAmount());

				sendersTransaction.setUserAccountNumber(moneyTransfer.getUserAccountNumber());

				sendersTransaction.setStatus("Debit");

				sendersTransaction.setCreateAt(date);

				sendersTransaction.setUpadateAt(date);

				

				customerTransactionsService.saveTransaction(sendersTransaction);



				

				long receiversAccountBalance = fetchReceiversAccount.getAccountBalance() + moneyTransfer.getAmount();

				

				accountDetailsService.updateAccountBalance(receiversAccountBalance,date,fetchReceiversAccount.getAccountNumber());

				

				CustomerTransactions receiversTransaction = new CustomerTransactions();

				receiversTransaction.setAccountNumber(fetchReceiversAccount.getAccountNumber());

				receiversTransaction.setAmount(moneyTransfer.getAmount());

				receiversTransaction.setUserAccountNumber(moneyTransfer.getAccountNumber());

				receiversTransaction.setStatus("Credit");

				receiversTransaction.setCreateAt(date);

				receiversTransaction.setUpadateAt(date);
				

				customerTransactionsService.saveTransaction(receiversTransaction);

				

				

				CustomerResponseForUser responseStructure = new CustomerResponseForUser(new Date(),"Money Transfered Successfull","200");

				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);

			}else {

				CustomerResponseForUser responseStructure = new CustomerResponseForUser(new Date(),"Recevivers Account Not Found","409");

				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);

			}

			

		}else {

			CustomerResponseForUser responseStructure = new CustomerResponseForUser(new Date(),"Senders Account Not Found","409");

			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);

		}

		

		
	}

	}

