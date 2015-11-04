package Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myfirstprogram.InvalidDataException;

public class Customer {
	private static Integer Id=0;
	private Integer customerId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String creditCard;
	private ArrayList<PurchasedItems> purchased;
	private Double totalPurchasedAmount;
	
public Customer(String first, String last, String phone){
	phoneNumberValidation(phone);//validate the phone number if its not valid throw exception
	this.firstName=first;
	this.lastName=last;
	this.phoneNumber=phone;	
	this.customerId=Id;
	this.creditCard=null;
	this.purchased=new ArrayList<PurchasedItems>();
	this.totalPurchasedAmount=0.0;
	Id++; //go to the next id so the next customer will have a new id
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public void setCreditCard(String creditCard) {
	this.creditCard = creditCard;
}

public Integer getCustomerId() {
	return customerId;
}

public String getFirstName() {
	return firstName;
}

public String getLastName() {
	return lastName;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public String getCreditCard() {
	return creditCard;
}

public ArrayList<PurchasedItems> getPurchased() {
	return purchased;
}

public Double getTotalPurchasedAmount() {
	return totalPurchasedAmount;
}
public void makePurchase(String itemName, String itemType, Integer numberPurchased, Double pricePerItem){
	//add purchase to arraylist of purchased items
	this.purchased.add(new PurchasedItems(itemName,numberPurchased, itemType,pricePerItem));
	//calculate amount the peroson need to pay and add it to the there current perchasedAmount
	this.totalPurchasedAmount += (numberPurchased*pricePerItem);
	//this.totalPurchased+= this.purchased.
}
public void returnPurchase(String itemName, GregorianCalendar datePurchased )throws notFoundExceptioin{
	//search through the ArrayList of purchased items to find the item this person bought
	Integer year = datePurchased.get(Calendar.YEAR);
	Integer month=datePurchased.get(Calendar.MONTH);
	Integer day=datePurchased.get(Calendar.DAY_OF_MONTH);
	boolean notFound=true; //keep track of weather the item was found
	do{//loop through until the item is found//To remove items from the list, start from the end and go backwards through the arrayList
		//This way if we remove one from the beginning as we go through, then we will avoid getting a runtime error
		//for java.lang.IndexOutOfBoundsException or java.util.ConcurrentModificationException as when we used the iterator
		
	for(int i=purchased.size()-1; i> -1; i--){
		if(purchased.get(i).getItemName().equalsIgnoreCase(itemName)){
		//check to see if it was bought on the day they said. Cant use equals method since that will compare the milliseconds of  
		//of time and that is may not be equal
			if (purchased.get(i).getDayBought().get(Calendar.DAY_OF_MONTH)==day &&
				purchased.get(i).getDayBought().get(Calendar.MONTH)==month  && 
				purchased.get(i).getDayBought().get(Calendar.YEAR)==year){
			// the item is found 
				notFound=false;
				//subtract price from totalPurchasedAmount
				this.totalPurchasedAmount-= purchased.get(i).costForMultipleItems();
				//remove item from ArrayList
				this.purchased.remove(purchased.get(i));
			} 
		}
		}
		//once the for loop is complete if the item was not found then throw a notFoundException, this stops the do-while from being an infanite loop
		if(notFound){
			throw new notFoundExceptioin();
		}
	}while(notFound); 
	
	}
public int timesPurchased(String item){
	int purchasedCounter=0;
	//search through the buyers items 
	for(PurchasedItems search: this.purchased){ //loop through all the purchased of the customer
		if(search.getItemName().equalsIgnoreCase(item)){
			purchasedCounter++	;	//each time he bought a particular item add one to the purchasedCounter 
		}
	}
	return purchasedCounter;
}
public ArrayList<PurchasedItems> purchaseOfType(String type){
	ArrayList<PurchasedItems> listOfType= new ArrayList<PurchasedItems>();
	for (PurchasedItems search: this.purchased){//loop through the items purchased for the given cutomer
		if(search.getItemType().equalsIgnoreCase(type)){//if it is the same type
			//copy the item with the type you are looking for into the new ArrayList
			listOfType.add(search);
		}
	}
	return listOfType;
}
public boolean hasPurchasedItem(String item){
	boolean found=false;
	for(PurchasedItems search:this.purchased){//loop throw all the purchased items of a customer
		if(search.getItemName().equalsIgnoreCase(item)){//if finds the item requested on the list
			found=true; //the item was found so return true
			return found;
		}
	}
	return found;//item not found
}
/** isPhoneNumberValid: Validate phone number using Java reg ex. 
* This method checks if the input string is a valid phone number. 
* @param email String. Phone number to validate 
* @return boolean: true if phone number is valid, false otherwise. 
*/  
private static void phoneNumberValidation(String phoneNumber){  
	//i did not use the multiple format option since when the user searches with a number they can use a diffrent format and then they will not find the number
	//okay formats are (111)111-1111 or 1111111111 or 111-111-1111 //"^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
String expression =  "\\d{3}-\\d{3}-\\d{4}";  
                                          
CharSequence inputStr = phoneNumber;  
Pattern pattern = Pattern.compile(expression);  
Matcher matcher = pattern.matcher(inputStr);  
if(!matcher.matches()){  //if the pattern matches the region then the phone number is valid format
  throw new InvalidDataException ();
}
}}  
 

		
	


