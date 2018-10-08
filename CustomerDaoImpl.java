package org.capg.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.capg.model.Account;
import org.capg.model.Address;
import org.capg.model.Customer;
import org.capg.model.Transaction;

public class CustomerDaoImpl implements ICustomerDao{
	
	private static List<Customer> customers=dummyDb();
	private static Set<Account> accounts;
	private static List<Transaction> transactions=new ArrayList<>();
	
	private static List<Customer> dummyDb(){
		List<Customer> customers=new ArrayList<>();
		
		Address address=new Address("23,west Car St", "2nd St", "Chennai", "TN", "234442");
		customers.add(new Customer(123,"Jack","Thomson", LocalDate.of(1991, 01, 23),
				"jack@gmail.com","8890912345",address));
		
		Address address1=new Address("North Avnnue", "2nd Cross St", "Hyderabad", "AP", "657657");
		customers.add(new Customer(1090,"Tom","Jerry", LocalDate.of(1987, 12, 23),
				"tom@gmail.com","9090912345",address1));
		
		return customers;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customers;
	}

	@Override
	public void createCustomer(Customer customer) {
		
		customers.add(customer);
		
	}

	@Override
	public void addAccount(Account account, Customer cust) {
		cust.getAccounts().add(account);
				
	}

	@Override
	public List<Transaction> getAllTransactions() {
		
		return transactions;
	}

	@Override
	public void addTransaction(Transaction transaction1) {
		transactions.add(transaction1);
		
	}
	

}
