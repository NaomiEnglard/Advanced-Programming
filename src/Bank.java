package myfirstprogram;

import java.util.ArrayList;

import javax.naming.NameNotFoundException;


public class Bank {
	private ArrayList<Account> accountList;
	private static int lastId=0;
	private int userid;
	
public Bank(){
	this(0.0); //set up a new account with no money
	
}
public Bank (double initialBalance){ //user inputs a balance and an account is set up with a id and the initial a balnce
	if(initialBalance<0){
		throw new InvalidDataException();
	}
	this.userid=lastId++;
	this.accountList=new ArrayList<Account>();
	accountList.add(new Account(userid, initialBalance));
}
public void depositToAccount (double amount) throws NameNotFoundException{
	
	//  otherwise will delegate the job of deposit to the appropriate instance of Account
	boolean found=false;
	for(Account aAccount: accountList){
		//find the account that has the id the user inputed
		if(aAccount.getId()==userid){
			aAccount.deposit(amount);
			found = true;
		}
	}
	//will throw exception if there is no such Accountid in ArrayList of Account
	if(!found){
		throw new NameNotFoundException();
	}
}
public void withdrawFromAccount(double amount) throws InsufficientFundsException, NameNotFoundException{
	boolean found = false;
	//It will delegate the job of withdraw to the appropriate Account instance. (which might throw the InsufficientFundsException error)
	for(Account aAccount: accountList){
		if(aAccount.getId() == userid){
			aAccount.withdraw(amount);
			found =true;
		}
		
	}
	//- will throw an exception if there is no such id in ArrayList of Account 
	if(!found){
		throw new NameNotFoundException();
	}
}
public Double getCurrentBalance() throws NameNotFoundException{  
	// it will delegate the job to that instance to getCurrentBalance(). it will return what the Account.getCurrentBalance() method returns.
	for(Account aAccount: accountList){	
		if(aAccount.getId() ==userid){
			return aAccount.getBalance();
		}
	}
	//throw exception if id was not found
	throw new NameNotFoundException();
	
	
}
public String getMiniStatement() throws NameNotFoundException {
	for(Account aAccount: accountList){
		if(aAccount.getId()==userid){
			return aAccount.toString();
		}
	}
	//if the account was not found then throw exception
	throw new NameNotFoundException();
}

public int getUserId(){
	return this.userid;
}
public double getLargestDeposit() throws NameNotFoundException, NullPointerException{
	for(Account aAccount: accountList){
		if(aAccount.getId()==userid){
			//try{
				return aAccount.getLargestDeposit();
			//}catch(NullPointerException a){
				//throw new NullPointerException();
			//}
			
		}
	}
	//if the account was not found then throw exception
	throw new NameNotFoundException();
}
public double getLargestWithdrawl() throws NameNotFoundException{
	for(Account aAccount: accountList){
		if(aAccount.getId()==userid){
			return aAccount.getLargestWithdrawl();
		}
	}
	//if the account was not found then throw exception
	throw new NameNotFoundException();
}
}




