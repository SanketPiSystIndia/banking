package com.banking.auth.customresponse;

import java.util.Date;

import com.banking.auth.entities.AccountDetails;

public class CustomResponseForAccountDetails {
	
	private Date timestamp;
	private String message;
	private String status;
	private AccountDetails  customer;
	public CustomResponseForAccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomResponseForAccountDetails(Date timestamp, String message, String status, AccountDetails customer) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.customer = customer;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AccountDetails getCustomer() {
		return customer;
	}
	public void setCustomer(AccountDetails customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomResponseForAccountDetails [timestamp=" + timestamp + ", message=" + message + ", status=" + status
				+ ", customer=" + customer + "]";
	}

	
}
