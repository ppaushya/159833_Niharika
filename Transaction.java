package org.capg.model;

import java.time.LocalDate;

public class Transaction {
	private long transactionId;
	public Transaction(long transactionId, LocalDate transactionDate, double amount, String description,
			String transactionType) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
	}
	private LocalDate transactionDate;
	private Account fromAccount;
	private Account toAccount;
	private double amount;
	private String description;
	private String transactionType;
	
	public Transaction() {
		
	}
	
	public Transaction(long transactionId, LocalDate transactionDate, Account fromAccount, Account toAccount,
			double amount, String description, String transactionType) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", fromAccount="
				+ fromAccount + ", toAccount=" + toAccount + ", amount=" + amount + ", description=" + description
				+ ", transactionType=" + transactionType + "]";
	}

}
