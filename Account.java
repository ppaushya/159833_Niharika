package org.capg.model;

import java.time.LocalDate;

public class Account {
	private long accountNumber;
	private AccountType accountType;
	private LocalDate openingDate;
	private double openingBalance;
	private String description;
	
	public Account() {
		
	}
	
	public Account(long accountNumber, AccountType accountType, LocalDate openingDate, double openingBalance,
			String description) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.openingDate = openingDate;
		this.openingBalance = openingBalance;
		this.description = description;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public LocalDate getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", openingDate="
				+ openingDate + ", openingBalance=" + openingBalance + ", description=" + description + "]";
	}
	
	

}
