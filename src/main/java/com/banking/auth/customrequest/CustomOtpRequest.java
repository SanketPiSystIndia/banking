package com.banking.auth.customrequest;


public class CustomOtpRequest {
	
	private String emailId;

	public CustomOtpRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomOtpRequest(String emailId) {
		super();
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "SendOtpOnEmailDTO [emailId=" + emailId + "]";
	}

}
