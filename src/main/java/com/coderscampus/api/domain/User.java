package com.coderscampus.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
	
	@Entity
	public class User {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long userId;
		private String farmName;
		private String product;
		private String phoneNumber;
		private String emailAddress;
		private String firstName;
		private String lastName;
		private String fullName;
		private String password;
		
		@JsonIgnore
		@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
		@PrimaryKeyJoinColumn
		private FarmDetails farmDetails;
		
		
		public FarmDetails getFarmDetails() {
			return farmDetails;
		}
		public void setFarmDetails(FarmDetails farmDetails) {
			this.farmDetails = farmDetails;
		}
		public String getFullName() {
			return fullName;
		}
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
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
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Long getId() {
			return userId;
		}
		public void setId(Long id) {
			this.userId = id;
		}
		public String getName() {
			return farmName;
		}
		public void setName(String name) {
			this.farmName = name;
		}
		public String getProduct() {
			return product;
		}
		public void setProduct(String product) {
			this.product = product;
		}
		public String getContactInfo() {
			return phoneNumber;
		}
		public void setContactInfo(String contactInfo) {
			this.phoneNumber = contactInfo;
		}
		@Override
		public String toString() {
			return "User [userId=" + userId + ", farmName=" + farmName + ", product=" + product + ", phoneNumber="
					+ phoneNumber + ", emailAddress=" + emailAddress + ", firstName=" + firstName + ", lastName="
					+ lastName + ", fullName=" + fullName + ", password=" + password + ", farmDetails=" + farmDetails
					+ "]";
		}

		
	}


