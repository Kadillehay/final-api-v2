package com.coderscampus.api.models;

public class AdminRequest {

	private String emailAddress;
	private String password;
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminRequest [emailAddress=" + emailAddress + ", password=" + password + "]";
	}
	
	
	
	
}
