package com.banking.auth.customrequest;

public class CustomOtpRequest {

	private String accountNumber;
	private String email;
	private String transactionPin;
	public CustomOtpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomOtpRequest(String accountNumber, String email, String transactionPin) {
		super();
		this.accountNumber = accountNumber;
		this.email = email;
		this.transactionPin = transactionPin;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	@Override
	public String toString() {
		return "CustomOtpRequest [accountNumber=" + accountNumber + ", email=" + email + ", transactionPin="
				+ transactionPin + "]";
	}
		
	}



