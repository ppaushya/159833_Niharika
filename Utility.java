package org.capg.util;

import java.util.List;
import java.util.Set;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.service.CustomerServiceImpl;
import org.capg.service.ICustomerService;

public class Utility {
	static Customer customer;
	static ICustomerService customerService=new CustomerServiceImpl();
	
	public static int generateNumber() {
		return (int)(Math.random()*100);
	}
	
	public static boolean isValidName(String name) {
		return name.matches("[a-zA-Z]{3,}");
	}

	
	public static boolean isValidEmail(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
	
	
	public static boolean isValidMobile(String mobile) {
		return mobile.matches("\\d{10}");
	}

	public static boolean isValidDob(String dob) {
		
		return dob.matches("[0,1,2,3]\\d{1}-[0,1]\\d{1}-(18|19|20)\\d{2}");
	}
	
	public static boolean isValidPincode(String pincode) {
		return pincode.matches("\\d{6}");
	}

	public static long generateAccountNo() {
		return (long)(Math.random()*100000);
	}

	public static boolean isValidBalance(double balance) {
		if(balance>1000)
			return true;
		else
		return false;
	}

	

	public static Customer isValidCustomer(int custId) {
		List<Customer> customers=customerService.getAllCustomers();
		
		for(Customer customer1:customers) {
			if(customer1.getCustomerId()==custId)
			{
				return customer1;
			}
		}
		return null;
		
	}
	public static Customer doesCustomerHasAccount(Customer customer1) {
		
			if(customer1.getAccounts().size()>0)
			{
				return customer1;
			}
		return null;
		
	}

	public static Account isValidAccount(Customer cust,long accNo) {
		Set<Account> accounts=cust.getAccounts();
		for(Account acc:accounts) {
			if(acc.getAccountNumber()==accNo)
				return acc;
		}
		return null;
	}

}
