package org.capg.dao;

import java.util.List;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.Transaction;

public interface ICustomerDao {
	
	public List<Customer> getAllCustomers();
	public void createCustomer(Customer customer);
	public void addAccount(Account account,Customer cust);
	public List<Transaction> getAllTransactions();
	public void addTransaction(Transaction transaction1);

}
