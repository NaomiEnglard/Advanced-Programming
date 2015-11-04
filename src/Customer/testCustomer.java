package Customer;
/*
 * return purchase needs help -look more at gregorian calander how to send date propely
 * 5: get back an address oops
 * 6: comes back as ab not a and b change the append
 * even if i remove a then i do 8 it will still tell me a bough dairy
 * make sure you cant add a customer with a phone number that is there
 */
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class testCustomer {
	public static void main(String[] args){
		//array list of customers
		ArrayList<Customer> customerList= new ArrayList<Customer>();
		int choice;
		do{
			menu();
		Scanner keyboard= new Scanner(System.in);
		choice = keyboard.nextInt();
		switch (choice){
		case 1:
			System.out.print("what is the customer's first name?:");
			keyboard.nextLine();
			String first = keyboard.nextLine(); 
			System.out.print("what is the customer's last name?:");
			String last=keyboard.nextLine();
			System.out.print("what is the cutomer's phone number?: use the format xxx-xxx-xxxx");
			String number = keyboard.nextLine();
			if(!checkPhoneNumber(number,customerList)){//if the phone number is not in the list
				System.out.println("the number already has an account try again");
				break;
			}
			customerList.add(new Customer(first,last,number));
			System.out.printf("a customer with the name %S %S was added, the phone number is %S",first,last,number);
		//	System.out.println("\n"+customerList.get(0).getPhoneNumber());
			break;
		case 2:
			//i choose phone number since unlike first or last name it is a unique identier
			keyboard.nextLine();
			System.out.print("what is the phone number of the customer you want to remove?:use the format xxx-xxx-xxxx");
			String phoneNumber = keyboard.nextLine(); 
			int index = search(phoneNumber,customerList);
			if(index==-1){
				System.out.println("this number was not found");
			}else{
				//if the number was found 
				Double checkBill =customerList.get(index).getTotalPurchasedAmount();
				if(checkBill > 0.0){//if the customer owes money inform the user before deleting the cutomer
					System.out.println("this customer owes "+checkBill+" they should pay it now since they are being removed from the list");
				}
				customerList.remove(index);
				System.out.println("The customer with phone number "+phoneNumber+" was removed");
			}
			break;
		case 3:
			keyboard.nextLine();//buffer
			System.out.print("what is the cutomer's phone number?: use the format xxx-xxx-xxxx");
			phoneNumber=keyboard.nextLine();
			index = search(phoneNumber,customerList);
			if(index==-1){
				System.out.println("this number was not found");
			}else{
			System.out.print("what item are you buying?:");
			String itemName=keyboard.nextLine();
			System.out.print("what type of itme is it?:");
			String type= keyboard.nextLine();
			System.out.print("how many are you buying?:");
			Integer amount=keyboard.nextInt();
			System.out.print("how much is one "+itemName+" ?:");
			Double price=keyboard.nextDouble();
			keyboard.nextLine();//buffer
			customerList.get(index).makePurchase(itemName, type, amount, price);
			System.out.println("you just bought "+itemName+" your total bill is now "+ customerList.get(index).getTotalPurchasedAmount());
			}
			break;
		case 4:
			keyboard.nextLine();//clearbuffer
			System.out.print("what is the cutomer's phone number?: use the format xxx-xxx-xxxx");
			phoneNumber =keyboard.nextLine();
			index = search(phoneNumber,customerList);
			if(index==-1){
				System.out.println("this number was not found");
			}else{
			System.out.print("what item are you returning?:");
			String itemName=keyboard.nextLine();
			System.out.print("what day of the month did you buy it?:");
			int day= keyboard.nextInt();
			System.out.print("what month did you buy it?(put in a two diget number, add a zero before if neccesary):");
			int month= keyboard.nextInt();
			month--; //decrease by one since month stored in gregorain calander start at zero
			System.out.print("what year did you buy it?:");
			int year= keyboard.nextInt();	
			GregorianCalendar purchsedDate= new GregorianCalendar();
			purchsedDate.set(year, month, day);
			try {
				customerList.get(index).returnPurchase(itemName, purchsedDate);
			} catch (notFoundExceptioin e) {
				e.printStackTrace();
			}
			}
			break;
		case 5:
			keyboard.nextLine();//clearbuffer
			System.out.print("what is the cutomer's phone number?: use the format xxx-xxx-xxxx");
			phoneNumber =keyboard.nextLine();
			index = search(phoneNumber,customerList);
			if(index==-1){
				System.out.println("this number was not found");
			}else{
				System.out.println(customerList.get(index).getPurchased());
			}
			break;
		case 6:
			keyboard.nextLine();//clearbuffer

			System.out.println("write an item, and you will see who purchased the item:");
			String itemSearch =keyboard.nextLine();
			StringBuffer buffer=new StringBuffer();
			boolean notfound=true;
			for(Customer search: customerList){
					if(search.hasPurchasedItem(itemSearch)){
					notfound=false;
					buffer.append("\t");
					buffer.append(search.getFirstName());
					buffer.append(" "+search.getLastName());
				}
			}
			if(notfound){
				System.out.println("no one purchased "+ itemSearch);
			}
			System.out.println(buffer);
			break;
		case 7:
			keyboard.nextLine();//clearbuffer
			System.out.print("what is the cutomer's phone number?: use the format xxx-xxx-xxxx");
			phoneNumber =keyboard.nextLine();
			index = search(phoneNumber,customerList);
			if(index==-1){
				System.out.println("this number was not found");
			}else{
				System.out.print("for which item do you want to see the amount of time it was purchased?:");
				String item = keyboard.nextLine();
				System.out.println(customerList.get(index).timesPurchased(item));
			}
			break;
		case 8:
			keyboard.nextLine();//clearbuffer
			System.out.println("write an type, and you will see who purchased the type of itme:");
			String typeSearch =keyboard.nextLine();
			StringBuffer bufferTwo = new StringBuffer();
			boolean notFound=true;
			for(Customer search: customerList){
				if(search.purchaseOfType(typeSearch)!=null){
					notFound=false;
					bufferTwo.append("\t");
					bufferTwo.append(search.getFirstName());
					bufferTwo.append(" "+search.getLastName());				}
			}if(notFound){
				System.out.println("No one purchased "+typeSearch);
			}
			System.out.println(bufferTwo);
			break;
		case 0:
			System.exit(1);
			break;
		}
		}while(choice !=0);
	}
public static void menu(){
	System.out.println("\n choose a menu choice:");
	System.out.println("1.	Add a new Customer \n"
			+ "2.	Remove a Customer \n"
			+ "3.	Add a customer purchase(for a particular customer , a particular item) \n"
			+ "4.	Return a Customer purchase  (for a particular customer, a particular PurchasedItem)\n"
			+ "5.	View Customer purchases (of a particular Customer) \n"
			+ "6.	List Names of Customers who have purchased a particular Item name\n"
			+ "7.	For each Customer, list how many times the Customer has purchased a particular item name\n"
			+ "8.	List which customers have purchased at least one item of a given item type \n"
			+"0. exit");
	

}
/*
 * method to search through all the customer to find a customer with a spacific telphone number
 * @param lookFor = the phone number that user inputed to find a spacific acount
 * @param customerList = array list to search through
 * @return postion=spot in array list where the number is found or null if not found
 */
public static int search(String lookFor,ArrayList<Customer> list){ //this has to be an int to solve the problem but then need to return null?
	for(int i=0;i<list.size();i++){
		try{
			if(list.get(i).getPhoneNumber().compareTo(lookFor)==0){
			return i ;
			}
		}
		catch(NullPointerException e){//if the list is empty
			return -1;
		}
	}
	return -1;
}
/*
 * check to see if anyone else has the phone number the new user wants to use
 *@param String number - the phone number the user wants to use
 *@param arraylist of customers
 *@returnn boolean  - if the number is alresy used
 */
public static boolean checkPhoneNumber(String number, ArrayList<Customer> list){
	for (Customer check: list ){
		if(check.getPhoneNumber().compareTo(number)==0){
			return false;
		}
	}
	return true;
}
}
