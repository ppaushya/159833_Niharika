package org.capg.service;

import java.time.LocalDate;
import java.util.List;

import org.capg.dao.CustomerDaoImpl;
import org.capg.dao.ICustomerDao;
import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.Transaction;

public class CustomerServiceImpl implements ICustomerService{
	
	private ICustomerDao customerDao=new CustomerDaoImpl();
	
	

	@Override
	public void createCustomer(Customer customer) {
		if(isValidCustomer(customer)) {
					customerDao.createCustomer(customer);
		}
		
		
	}
	
	private boolean isValidCustomer(Customer customer) {
		boolean flag=false;
		
		if(customer.getDateOfBirth().isBefore(LocalDate.now())) {
			if(customer.getMobile().matches("(7|8|9)\\d{9}"))
				flag=true;
			else
				flag=false;
		}else
			flag=false;
		
		
		return flag;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
	}

	@Override
	public void addAccount(Account account, Customer cust) {
		
		customerDao.addAccount(account, cust);
	}

	@Override
	public List<Transaction> getAllTransactions() {
		return customerDao.getAllTransactions();
	}

	@Override
	public void addTransaction(Transaction transaction) {
		customerDao.addTransaction(transaction);
		
	}

}
