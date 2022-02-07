package com.banking.auth.customresponse;

import java.util.Date;

import com.banking.auth.entities.Customers;

public class CustomeResponseForCustomerRegister {
	
	private Date timestamp;
	private String message;
	private String status;
	private Customers customer;
	
	public CustomeResponseForCustomerRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomeResponseForCustomerRegister(Date timestamp, String message, String status, Customers customer) {
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
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomeResponseForCustomerRegister [timestamp=" + timestamp + ", message=" + message + ", status="
				+ status + ", customer=" + customer + "]";
	}
	


}
