package com.banking.auth.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customresponse.CustomResponseForAccountDetails;
import com.banking.auth.customresponse.CustomResponseForNoUser;
import com.banking.auth.customresponse.CustomeResponseForCustomerRegister;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.service.AccountSerive;
import com.banking.auth.service.CustomerService;
import com.banking.auth.util.AccountNumberGenerator;
import com.banking.auth.util.MailService;
import com.banking.auth.util.Validations;


@CrossOrigin
@RestController
@RequestMapping("/customer/auth")
public class CustomerAuthenticationController {
	
	static final Logger log = LoggerFactory.getLogger(CustomerAuthenticationController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountSerive accountSerive;
	
	@Autowired
	Validations validations;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	AccountNumberGenerator accountNumberGenerator;
	
	
	@Autowired
	MailService mailService;
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<Object> registerCustomer(@RequestBody Customers customer){
		
		
		validations.registerCustomer(customer);
		
		Customers findCustomer = customerService.findCustomerByEmail(customer.getEmail());
		if(findCustomer == null) {
			Customers registerdCustomer = customerService.registerCustomer(customer);
			
			AccountDetails accountDetails = new AccountDetails();
			
			accountDetails.setAccountNumber(registerdCustomer.getAccountNumber());
			accountDetails.setBranchName("Pune");
			accountDetails.setCustomerId(registerdCustomer);
			accountDetails.setAccountBalance(0);
			accountDetails.setIfsc("PARK202122");
			accountDetails.setStatus(registerdCustomer.getStatus());
			
			accountDetails.setCreatedAt(registerdCustomer.getCreatedAt());
			accountDetails.setUpdatedAt(registerdCustomer.getUpdatedAt());
			
			customerService.addAccountDetails(accountDetails);
		
			
			CustomeResponseForCustomerRegister responseStructure = new CustomeResponseForCustomerRegister(new Date(),
					"Customer Registerd Succesfully","200",registerdCustomer);

			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Customer already registered with the same email address.!!","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}
			
	}
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<Object> loginCustomer(@RequestBody Customers customer){
		
		validations.loginCustomer(customer);
		
		Customers findCustomer = customerService.findCustomerByEmail(customer.getEmail());
		if(findCustomer != null) {
			log.info(findCustomer.getPassword());
			
			
			if(encoder.matches(customer.getPassword(),findCustomer.getPassword()) == true) {
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Login Successful..!!","200");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}else {
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Invalid Credentials","400");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}
			
		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Customer not found","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/fetchAccountDetails")
	public ResponseEntity<Object> fetchAccountDetails(@RequestBody AccountDetails accountDetails){
		
		
		AccountDetails accountDetail = accountSerive.fetchAccountDetails(accountDetails.getAccountNumber());
		
		if(accountDetail != null) {
			
			CustomResponseForAccountDetails responseStructure = new CustomResponseForAccountDetails(new Date(),"Account Details Fetche Successfully","200",accountDetail);
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		
		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Invalid Account Number","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}

		
	}

	
	@PostMapping("/sendOtpOnEmail")
	public ResponseEntity<Object> sendOtpOnEmail(@RequestBody Customers customer){
		
		Customers findCustomer = customerService.findCustomerByEmail(customer.getEmail());
		
		if(findCustomer != null) {
			boolean sendEmail = mailService.sendMail(customer.getEmail(), accountNumberGenerator.generateTransactionPin());
			if(sendEmail == true) {
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"OTP Sent On Email...!!","200");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}else {
				CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Error! Sending otp","404");
				return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
			}

		}else {
			CustomResponseForNoUser responseStructure = new CustomResponseForNoUser(new Date(),"Mail id not found","409");
			return new ResponseEntity<Object> (responseStructure,HttpStatus.OK);
		}
		
	}
}
