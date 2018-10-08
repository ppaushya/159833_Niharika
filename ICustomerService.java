package org.capg.service;

import java.util.List;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.Transaction;

public interface ICustomerService {

	public void createCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public void addAccount(Account account,Customer cust);
	public List<Transaction> getAllTransactions();
	public void addTransaction(Transaction transaction);
}
