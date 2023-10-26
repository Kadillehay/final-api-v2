package com.coderscampus.api.models;

public class UserModel {

	private String emailAddress;
	private String password;
	private String originalEmail;
	private String originalPassword;
	private String farmName;
	private String phoneNumber;

	public String getFarmName() {
		return farmName;
	}

	public void setFarmName(String farmName) {
		this.farmName = farmName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOriginalEmail() {
		return originalEmail;
	}

	public void setOriginalEmail(String originalEmail) {
		this.originalEmail = originalEmail;
	}

	public String getOriginalPassword() {
		return originalPassword;
	}

	public void setOriginalPassword(String originalPassword) {
		this.originalPassword = originalPassword;
	}

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
		return "UserModel [emailAddress=" + emailAddress + ", password=" + password + ", originalEmail=" + originalEmail
				+ ", originalPassword=" + originalPassword + ", farmName=" + farmName + ", phoneNumber=" + phoneNumber
				+ "]";
	}


}
