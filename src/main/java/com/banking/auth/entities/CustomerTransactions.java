package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class CustomerTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	private String userAccountNumber;
	private long amount;
	private String tranctionPin;
	private String upadateAt;
	private String createAt;
	private String Status;
	public CustomerTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerTransactions(long id, String accountNumber, String userAccountNumber, long amount,
			String tranctionPin, String upadateAt, String createAt, String status) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.tranctionPin = tranctionPin;
		this.upadateAt = upadateAt;
		this.createAt = createAt;
		Status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getTranctionPin() {
		return tranctionPin;
	}
	public void setTranctionPin(String tranctionPin) {
		this.tranctionPin = tranctionPin;
	}
	public String getUpadateAt() {
		return upadateAt;
	}
	public void setUpadateAt(String upadateAt) {
		this.upadateAt = upadateAt;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "CustomerTransactions [id=" + id + ", accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", tranctionPin=" + tranctionPin + ", upadateAt="
				+ upadateAt + ", createAt=" + createAt + ", Status=" + Status + "]";
	}
}

