package com.banking.auth.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customrequest.CustomRequestForMoneyTransfer;
import com.banking.auth.customresponse.CustomResponseForNoUser;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.CustomerTransactions;
import com.banking.auth.service.AccountSerive;
import com.banking.auth.service.CustomerTransactionService;
import com.banking.auth.util.Validations;

@CrossOrigin
@RestController
@RequestMapping("/customer/transactions")
public class CustomerTransactionsController {
	
	@Autowired
	AccountSerive accountSerive;
	
	@Autowired
	CustomerTransactionService customerTransactionService;
	
	@Autowired
	Validations validations;
	
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	@PostMapping("/addBalance")
	public ResponseEntity<Object> addBalance(@RequestBody AccountDetails accountDetails){
		
		validations.addBalanceValidations(accountDetails);

		
		AccountDetails fetchedAccountDetails = accountSerive.fetchAccountDetails(accountDetails.getAccountNumber());
		if(fetchedAccountDetails != null) {
			
			long accountBalance = fetchedAccountDetails.getAccountBalance() + accountDetails.getAccountBalance();
			
			String date = ""+dateFormat.format(new Date()) ;
			
			accountSerive.updateAccountBalance(accountBalance,date,accountDetails.getAccountNumber());
			
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Account Balance Updated Successfully","409");
			return new ResponseEntity<Object>(responseStructure,HttpStatus.OK);
			
		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Invalid Account Number","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}

		
	}
	
	@PostMapping("/transferMoney")
	public ResponseEntity<Object> transferMoney(@RequestBody CustomRequestForMoneyTransfer moneyTransfer){
		
		AccountDetails fetchedAccountDetails = accountSerive.fetchAccountDetails(moneyTransfer.getAccountNumber());
		
		if(fetchedAccountDetails != null) {
			
			AccountDetails fetchReceiversAccount = accountSerive.fetchAccountDetails(moneyTransfer.getUserAccountNumber());
			
			if(fetchReceiversAccount != null) {
				long sendersAccountBalance = fetchedAccountDetails.getAccountBalance() - moneyTransfer.getAmount();
				
				String date = ""+dateFormat.format(new Date()) ;
				
				accountSerive.updateAccountBalance(sendersAccountBalance,date,fetchedAccountDetails.getAccountNumber());
				
				
				CustomerTransactions sendersTransactionLog = new CustomerTransactions();
				sendersTransactionLog.setAccountNumber(fetchedAccountDetails.getAccountNumber());
				sendersTransactionLog.setAmount(moneyTransfer.getAmount());
				sendersTransactionLog.setUserAccountNumber(moneyTransfer.getUserAccountNumber());
				sendersTransactionLog.setTransactionStatus("Debit");
				sendersTransactionLog.setCreatedAt(date);
				sendersTransactionLog.setUpdatedAt(date);
				
				customerTransactionService.saveTransactionLog(sendersTransactionLog);

				
				long receiversAccountBalance = fetchReceiversAccount.getAccountBalance() + moneyTransfer.getAmount();
				
				accountSerive.updateAccountBalance(receiversAccountBalance,date,fetchReceiversAccount.getAccountNumber());
				
				CustomerTransactions reveiversTransactionLog = new CustomerTransactions();
				reveiversTransactionLog.setAccountNumber(fetchReceiversAccount.getAccountNumber());
				reveiversTransactionLog.setAmount(moneyTransfer.getAmount());
				reveiversTransactionLog.setUserAccountNumber(moneyTransfer.getAccountNumber());
				reveiversTransactionLog.setTransactionStatus("Credit");
				reveiversTransactionLog.setCreatedAt(date);
				reveiversTransactionLog.setUpdatedAt(date);
				
				customerTransactionService.saveTransactionLog(reveiversTransactionLog);
				
				
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Money Transfered Successfull","200");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}else {
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Recevivers Account Not Found","409");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}
			
		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Senders Account Not Found","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}
		
		
	}
	

}
