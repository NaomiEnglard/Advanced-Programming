package bank;

import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.NameNotFoundException;

public class Atm {
	public static void main(String[] args) {
		ArrayList<Bank> bankAccounts = new ArrayList<Bank>();
		//invoke 10 dummy accounts
		bankAccounts.add(new Bank(100.00));		
		bankAccounts.add(new Bank(100.0));
		bankAccounts.add(new Bank(6000000.25));
		bankAccounts.add(new Bank(5678.0));
		bankAccounts.add(new Bank(876543.98));
		bankAccounts.add(new Bank(23.98));
		bankAccounts.add(new Bank(345.65));
		bankAccounts.add(new Bank(8335.56));
		bankAccounts.add(new Bank(275.47));
		bankAccounts.add(new Bank(426.44));
	Scanner keyboard = new Scanner(System.in);
	Bank tempBank ;
	Integer choice;
	int idInput = getid(bankAccounts);
	tempBank=searchArray(bankAccounts, idInput);
	do{
		choice=menu();
		while(choice==null){
			System.out.println("this is not a valid choice please try again");
			choice = menu();
		}
		if(tempBank ==null){
			System.out.println("this account does not exist, try again");
		}else{
					
			switch (choice){
			case 1:
				try {
					System.out.println(tempBank.getCurrentBalance());
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("how much would you like to withdraw?");
				double amount = keyboard.nextDouble();
				try {
					tempBank.withdrawFromAccount(amount);
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				} catch (InsufficientFundsException e) {
					System.out.println("sorry you dont have enough money to do that");
				}
				
				break;
			case 3:
				System.out.println("how much would you like to deposit?");
				amount = keyboard.nextInt();
				try {
					tempBank.depositToAccount(amount);
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println(tempBank.getMiniStatement());
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					System.out.println(tempBank.getLargestDeposit());
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}catch(NullPointerException a){
					System.out.println("no deposits where made for this id");
				}
				break;
			case 6:
				try {
					System.out.println(tempBank.getLargestWithdrawl());
				} catch (NameNotFoundException e) {
					e.printStackTrace();
				}catch(NullPointerException a){
					System.out.println("no withdrawls where made for this id");
				}
				break;
			case 0:
				idInput=getid(bankAccounts);
				tempBank=searchArray(bankAccounts, idInput);
				break;

		}
		}	
	}while(choice !=-1);//this will keep looping since the choice can never be -1

		
	}

	public static Integer menu() {
		System.out.println("Choose a number from the menu");
		System.out.println("1: check balance");
		System.out.println("2: withdraw");
		System.out.println("3: deposit");
		System.out.println("4: get mini statement");
		System.out.println("5: get largest deposit");
		System.out.println("6: get largest withdrawl");
		System.out.println("0: exit");
		Scanner keyboard = new Scanner(System.in);
		int option = keyboard.nextInt();
		if(option<0||option>7){
			return null;
		}
		return option;

	}
	public static Bank searchArray (ArrayList<Bank> list, int id){
		for(Bank aBank: list){
			if(aBank.getUserId()==id){
				return aBank;
			}
		}
		return null;
	}
	public static int getid(ArrayList<Bank> bankAccounts){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter your id");
		int idInput = keyboard.nextInt();
		//validate id
		while (idInput<0 ||idInput>bankAccounts.size()){
			System.out.println("this is not a valid id please try again, what is your id");
			 idInput = keyboard.nextInt();
		}
		 return idInput;

	}

}
