package com.banking.auth.customrequest;

public class CustomRequestForMoneyTransfer {
	
	private String accountNumber;
	private String userAccountNumber;
	private long amount;
	private String upadateAt;
	private String createAt;
	private String status;
	public CustomRequestForMoneyTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomRequestForMoneyTransfer(String accountNumber, String userAccountNumber, long amount, String upadateAt,
			String createAt, String status) {
		super();
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.upadateAt = upadateAt;
		this.createAt = createAt;
		this.status = status;
	}
	@Override
	public String toString() {
		return "CustomRequestForMoneyTransfer [accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", upadateAt=" + upadateAt + ", createAt=" + createAt
				+ ", status=" + status + "]";
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
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	}

    