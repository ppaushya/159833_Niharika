package org.capg.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private int customerId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String emailId;
	private String mobile;
	private Address address;
	private Set<Account> accounts=new HashSet<>();
	public Customer() {
		
	}
		
	
	
	public Customer(int customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobile, Address address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobile = mobile;
		this.address = address;
	}




	public Customer(int customerId, String firstName, String lastName, LocalDate dateOfBirth, String emailId,
			String mobile, Address address, Set<Account> accounts) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mobile = mobile;
		this.address = address;
		this.accounts = accounts;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", emailId=" + emailId + ", mobile=" + mobile + ", address="
				+ address + ", accounts=" + accounts + "]";
	}
	
	
	

}
