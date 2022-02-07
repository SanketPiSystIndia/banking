package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String password;
	private String aadharNumber;
	private String panNumber;
	private String mobile;
	private String email;
	private String birthDate;
	private String address;
	private String accountNumber;
	private String transactionPin;
	private String status;
	private String createdAt;
	private String updatedAt;
	
	
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Customers(long customerId, String firstName, String middleName, String lastName, String password,
			String aadharNumber, String panNumber, String mobile, String email, String birthDate, String address,
			String accountNumber, String transactionPin, String status, String createdAt, String updatedAt) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.password = password;
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;
		this.mobile = mobile;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
		this.accountNumber = accountNumber;
		this.transactionPin = transactionPin;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getTransactionPin() {
		return transactionPin;
	}
	public void setTransactionPin(String transactionPin) {
		this.transactionPin = transactionPin;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", password=" + password + ", aadharNumber=" + aadharNumber
				+ ", panNumber=" + panNumber + ", mobile=" + mobile + ", email=" + email + ", birthDate=" + birthDate
				+ ", address=" + address + ", accountNumber=" + accountNumber + ", transactionPin=" + transactionPin
				+ ", status=" + status + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	


}
