package org.capg.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.capg.model.Account;
import org.capg.model.AccountType;
import org.capg.model.Address;
import org.capg.model.Customer;
import org.capg.model.Transaction;
import org.capg.service.CustomerServiceImpl;
import org.capg.service.ICustomerService;
import org.capg.util.Utility;

public class UserInteraction {
	Customer customer;
	Scanner scanner=new Scanner(System.in);
	ICustomerService customerService=new CustomerServiceImpl();
	Transaction transaction=new Transaction();
		
	public void printCustomers(List<Customer> customers) {
		System.out.println("CustomerId\tCustomerName\tEmailId\t\tMobile");
		System.out.println("-----------------------------------------------------------------------------");
		
		for(Customer customer:customers) {
			System.out.println(customer.getCustomerId()
					+"\t\t"+customer.getFirstName()+" " + customer.getLastName()
					+"\t"+ customer.getEmailId() + "\t" + customer.getMobile() );
		}
	}
	
	public Customer getCustomerDetails() {
		
		customer=new Customer();
		
		customer.setCustomerId(Utility.generateNumber());
		customer.setFirstName(promptFirstName());
		customer.setLastName(promptLastName());
		customer.setEmailId(promptEmailId());
		customer.setMobile(promptMobile());
		customer.setDateOfBirth(promptDateOfBirth());
		
		customer.setAddress(getAddressDetails());
		
		return customer;
	}
		
	public Address getAddressDetails() {
		Address address=new Address();
		System.out.println("Enter AddressLine1:");
		address.setAddressLine1(scanner.next());
		System.out.println("Enter AddressLine2:");
		address.setAddressLine2(scanner.next());
		System.out.println("Enter City:");
		address.setCity(scanner.next());
		System.out.println("Enter State:");
		address.setState(scanner.next());
		address.setPincode(promptPincode());
		return address;
	}
	
	public Account getAccountDetails(Customer cust) {
		Account account=new Account();
		AccountType[] accountType=AccountType.values();
		account.setAccountNumber(Utility.generateAccountNo());
		System.out.println("Enter Account Type:");
		int choose,count = 0;
		for(AccountType acc:accountType) {
			System.out.println(++count+"."+acc);
		}
		choose=scanner.nextInt();
		
		switch(choose){
			case 1:
				account.setAccountType(AccountType.SAVINGS);
				break;
			case 2:
				account.setAccountType(AccountType.CURRENT);
				break;
			case 3:
				account.setAccountType(AccountType.RD);
				break;
			case 4:
				account.setAccountType(AccountType.FD);
				break;
			default:
				System.out.println("Enter valid Account Type");
				break;
		}
		
		account.setOpeningDate(LocalDate.now());
		boolean flag;
		do {
		System.out.println("Enter opening Balance");
		double balance=scanner.nextDouble();
		flag=Utility.isValidBalance(balance);
		if(flag)
			account.setOpeningBalance(balance);
		else
			System.out.println("Enter valid opening balance[>1000]");
		}while(!flag);
		System.out.println("Enter description");
		String description=scanner.next();
		account.setDescription(description);
				
		return account;
	}
	
	
	public String promptPincode() {
		boolean flag=false;
		String pincode;
		do {
			System.out.println("Enter pincode:");
			pincode=scanner.next();
			flag=Utility.isValidPincode(pincode);
			if(!flag)
				System.out.println("Please enter Valid pincode!");
		}while(!flag);
		
		return pincode;
	}

	public LocalDate promptDateOfBirth() {
		boolean flag=false;
		String dob;
		do {
			System.out.println("Enter DateOfBirth[dd-mm-yyyy]:");
			dob=scanner.next();
			flag=Utility.isValidDob(dob);
			if(!flag)
				System.out.println("Please enter Valid Date!");
		}while(!flag);
		String[] dates=dob.split("-");
		LocalDate date=LocalDate.of(Integer.parseInt(dates[2]), 
				Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));
		return date;
	}
	
	public String promptMobile() {
		boolean flag=false;
		String mobile;
		do {
			System.out.println("Enter mobile Number:");
			mobile=scanner.next();
			flag=Utility.isValidMobile(mobile);
			if(!flag)
				System.out.println("Please enter Valid 10 digit Mobile!");
		}while(!flag);
		
		return mobile;
	}
	
	public String promptFirstName() {
		boolean flag=false;
		String fname;
		do {
			System.out.println("Enter FirstName:");
			fname=scanner.next();
			flag=Utility.isValidName(fname);
			if(!flag)
				System.out.println("Please enter Valid FirstName!");
		}while(!flag);
		
		return fname;
	}
	
	public String promptLastName() {
		boolean flag=false;
		String fname;
		do {
			System.out.println("Enter LastName:");
			fname=scanner.next();
			flag=Utility.isValidName(fname);
			if(!flag)
				System.out.println("Please enter Valid LastName!");
		}while(!flag);
		
		return fname;
	}
	
	public String promptEmailId() {
		boolean flag=false;
		String email;
		do {
			System.out.println("Enter EmailId:");
			email=scanner.next();
			flag=Utility.isValidEmail(email);
			if(!flag)
				System.out.println("Please enter Valid EmailId!");
		}while(!flag);
		
		return email;
	}


	public void printError(String message) {
		System.out.println(message);
		
	}

	public Transaction creditDebit(Customer cust) {
		Set<Account> accounts=cust.getAccounts();
		System.out.println("Account Number\tAccount Type");
		for(Account acc:accounts) {
			System.out.println(acc.getAccountNumber()+"\t"+acc.getAccountType());
		}
			System.out.println("enter account number");
			long accNo=scanner.nextLong();
			Account account=Utility.isValidAccount(cust, accNo);
			if(account!=null)
			{
				List<Transaction> transactions=customerService.getAllTransactions();
				transaction.setTransactionId((long)(Math.random()*1000));
				transaction.setTransactionDate(LocalDate.now());
				transaction.setFromAccount(null);
				transaction.setToAccount(account);
				System.out.println("Enter type of transaction:\n1.Credit\n2.Debit");
				byte transType=scanner.nextByte();
				switch(transType) {
				case 1:
					transaction.setTransactionType("Credit");
					System.out.println("Enter amount to be credited[>0]");
					double amount=scanner.nextDouble();
					transaction.setAmount(amount);
					double currentBalance1=findCurrentBalance(account,transactions);
					System.out.println("Your Current balance is:");
					System.out.print(currentBalance1+amount+"\n");
					
					break;
				case 2:
					transaction.setTransactionType("Debit");
					double currBal=findCurrentBalance(account,transactions);
					System.out.println("Enter amount to be debited less than "+currBal);
					double amount1=scanner.nextDouble();
					while(amount1>currBal) {
						System.out.println("Invalid debit Amount!!Enter amount less than "+currBal);
						amount1=scanner.nextDouble();
						
					}
					double currentBalance=findCurrentBalance(account,transactions);
					System.out.println("Your Current balance is:");
					System.out.print(currentBalance-amount1+"\n");
					break;
				default:
					System.out.println("enter valid type of transaction");
					break;
				}
								
			}
			else
				System.out.println("enter valid account number");
			
			return transaction;
		}

	public double findCurrentBalance(Account account,List<Transaction> transactions) {
		double currentBalance=account.getOpeningBalance();
		for(Transaction trans:transactions) {
			if(account.getAccountNumber()==trans.getToAccount().getAccountNumber()) {
				if(trans.getTransactionType().equals("Debit")) {
					currentBalance+=trans.getAmount();
				}
				else if(trans.getTransactionType().equals("Credit")) {
					currentBalance-=trans.getAmount();
				}
					
			}
		}
			
		return currentBalance;
		
	}

	public Transaction fundsTransfer(Customer cust) {
		transaction.setFromAccount(getFromAccount(cust));
		System.out.println("Enter your Account number from below Accounts:");
		Set<Account> accounts=cust.getAccounts();
		System.out.println("Account Number\tAccount Type");
		for(Account acc:accounts) {
			System.out.println(acc.getAccountNumber()+"\t\t"+acc.getAccountType());
			
		}
		long accNo=scanner.nextLong();
		Account account=Utility.isValidAccount(cust, accNo);
		
	
		return null;
	}

	public Account getFromAccount(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Transaction> printTransactions(Customer cust) {
		System.out.println("Enter your Account number from below Accounts:");
		Set<Account> accounts=cust.getAccounts();
		System.out.println("Account Number\tAccount Type");
		for(Account acc:accounts) {
			System.out.println(acc.getAccountNumber()+"\t\t"+acc.getAccountType());
		}
		long accNo=scanner.nextLong();
		Account account=Utility.isValidAccount(cust, accNo);
		List<Transaction> accountSummary=new ArrayList<>();
		List<Transaction> trans=customerService.getAllTransactions();
		for(Transaction transaction:trans) {
			if(transaction.getToAccount()==account) {
				accountSummary.add(transaction);
			}
		}
		return accountSummary;
	}
		
	
	
	
}
