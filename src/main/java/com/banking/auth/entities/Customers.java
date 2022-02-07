package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customers {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	private String tranctionPin;
	private String upadateAt;
	private String createAt;
	private String status;
	
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customers(long customerId, String firstName, String middleName, String lastName, String password,
			String aadharNumber, String panNumber, String mobile, String email, String birthDate, String address,
			String accountNumber, String tranctionPin, String upadateAt, String createAt, String status) {
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
		this.tranctionPin = tranctionPin;
		this.upadateAt = upadateAt;
		this.createAt = createAt;
		this.status = status;
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
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", password=" + password + ", aadharNumber=" + aadharNumber
				+ ", panNumber=" + panNumber + ", mobile=" + mobile + ", email=" + email + ", birthDate=" + birthDate
				+ ", address=" + address + ", accountNumber=" + accountNumber + ", tranctionPin=" + tranctionPin
				+ ", upadateAt=" + upadateAt + ", createAt=" + createAt + ", status=" + status + "]";
	}
	
	
	
	

}
