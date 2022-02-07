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
	private String transactionStatus;
	private String createdAt;
	private String updatedAt;
	
	
	public CustomerTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CustomerTransactions(long id, String accountNumber, String userAccountNumber, long amount,
			String transactionStatus, String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.transactionStatus = transactionStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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
	
	public String getTransactionStatus() {
		return transactionStatus;
	}


	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "CustomerTransactions [id=" + id + ", accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
	
	
	

}
