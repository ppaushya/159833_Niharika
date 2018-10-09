package org.capg.boot;

import java.util.List;
import java.util.Scanner;

import org.capg.model.Account;
import org.capg.model.Customer;
import org.capg.model.Transaction;
import org.capg.service.CustomerServiceImpl;
import org.capg.service.ICustomerService;
import org.capg.util.Utility;
import org.capg.view.UserInteraction;

public class Boot {
static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		ICustomerService customerService=new CustomerServiceImpl();
		UserInteraction userInteraction=new UserInteraction();
		
		int  choice;
		String option;
		do {
		System.out.println("1.Create Customer");
		System.out.println("2.List Customers");
		System.out.println("Enter Your choice:");
		choice=scanner.nextInt();
				
			switch(choice) {		
			case 1:
				
				int count=customerService.getAllCustomers().size();
				Customer customer=userInteraction.getCustomerDetails();
				customerService.createCustomer(customer);
				if(count==customerService.getAllCustomers().size())
					userInteraction.printError("Customer Creation Error! Please Try Again!");
				break;
			case 2:
				
				List<Customer> customers= customerService.getAllCustomers();
				userInteraction.printCustomers(customers);
				int custId;
				Customer cust;
				do {
				System.out.println("Enter customer Id");
				custId=scanner.nextInt();
				cust=Utility.isValidCustomer(custId);
				if(cust!=null) {
					System.out.println("Enter your choice");
					System.out.println("1.Create Account");
					System.out.println("2. Deposit/Withdraw");
					System.out.println("3. Funds Transfer");
					System.out.println("4. Account Summary");
					int sel=scanner.nextInt();
					switch(sel) {
					case 1:
						Account account=userInteraction.getAccountDetails(cust);
						customerService.addAccount(account, cust);
						System.out.println("Your account is created successfully");
						System.out.println(cust);
						break;
					case 2:
						if(Utility.doesCustomerHasAccount(cust)!=null) {
							Transaction transaction=userInteraction.creditDebit(cust);
							customerService.addTransaction(transaction);
						}
						else {
							System.out.println("Customer Doesn't have any account!!Please create new account");
						}
											
						break;
					case 3:
						if(Utility.doesCustomerHasAccount(cust)!=null) {
							Transaction transaction=userInteraction.fundsTransfer(cust);
							customerService.addTransaction(transaction);
						}
						else {
							System.out.println("Customer Doesn't have any account!!Please create new account");
						}
						break;
					case 4:
						if(Utility.doesCustomerHasAccount(cust)!=null) {
						List<Transaction> accountSummary=userInteraction.printTransactions(cust);
						for(Transaction trans:accountSummary) {
							System.out.println(trans);
						}
						
						}
						
						break;
					default:
						System.out.println("Sorry! Invalid Choice");
						System.exit(0);
					
					}				
				}
							
				else 
				System.out.println("Enter valid customer Id");
			
					
				}while(cust==null);
				break;
			
			default:
				System.out.println("Sorry! Invalid Choice");
				System.exit(0);
		}
			System.out.println("Do you wish to contine?[y|n]:");
			option=scanner.next();		
							
		}while(option.charAt(0)=='y' || option.charAt(0)=='Y');
		
	
	}


}
