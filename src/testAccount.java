package myfirstprogram;

import java.util.GregorianCalendar;

public class testAccount {
	public static void main(String[] args) {
		GregorianCalendar begining = new GregorianCalendar();
		// create and instance of account
		Account firstAccount = new Account(1122, 20000);
		// set AIR to 4.5%
		firstAccount.setAnnualInterestRate(4.5);
		// withdraw 2500
		try {
			firstAccount.withdraw(2500);
			firstAccount.withdraw(25);
			firstAccount.withdraw(200);
			firstAccount.withdraw(20);
			
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		// deposit
		firstAccount.deposit(3000);
		System.out.println("For account with id: " + firstAccount.getId()
				+ "\t the balance is: $" + firstAccount.getBalance()
				+ "\t The monthly intrest is: $"	+ firstAccount.getMonthlyInterst()
				+ "\t the account was set up on day: " + firstAccount.getDateCreated());
		GregorianCalendar today = new GregorianCalendar();
		firstAccount.deposit(100);
		firstAccount.deposit(120);
		firstAccount.deposit(140);
		System.out.println(firstAccount.getBalance());
		System.out.println(firstAccount.getBalanceAsOf(today));
		System.out.println(firstAccount.printStatement(begining, today));
		System.out.println(firstAccount.getLargestDeposit());
		System.out.println(firstAccount.getLargestDeposit());

		
		
		
		//i added some extra things to practice equals, toString, and compare
		/*//this will show the same thing as the line above it just uses a toSting instead of getters and println
		System.out.println(firstAccount.toString());
		//compare to
		Account secondAccount = new Account(4,20500);
		int compare = firstAccount.compareTo(secondAccount);
		 if(compare<0){
			 System.out.println("The first account was created before the second account");
		 } else if(compare==0){
			 System.out.println("The first account was created at the same time as the second account");
		 }else{
			 System.out.println("The first account was created after the second account");
		 }
		 //equals
		 boolean equal = firstAccount.equals(secondAccount);
		 if (equal){
			 System.out.println("these two accounts have the same balance");
		 }else{
			 System.out.println("these accounts do not have the same balance");
		 }
		//
		/* test out examples
		Account secondAccount = new Account();
		System.out.println(secondAccount.getId());
		Account three= new Account();
		System.out.println(three.getId());
		Account four = new Account (1122, 50);
		four.withdraw(50);
		System.out.println(four.getDateCreated());
		System.out.println(four.toString()); */
		
		
		}
}
