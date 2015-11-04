package stocks;

import java.util.ArrayList;

public class testCellPhoneFixed {
	public static void main(String[] args){
		//maintain a list of Contact instances
		//create an arrayList that holds datatype contact1
		ArrayList <Contact1> phoneBook = new ArrayList<Contact1>();
			//other choice
			//Contact1[] listOfContacts = new Contact1[100]; //this choice needs a counter
		//add contact there are two ways
		phoneBook.add(new Contact1("Naomi","Englard","nb","7187787778"));
			//other way to add contact
			// Contact1 acontact = new Contact1("Naomi","Englard","nb","7187787778");
			//phoneBook.add(acontact);
		//if you are ussing a regular array not an array list you would put it in like this:
		//listOFContacts[number++]=new Contact1("Naomi","Englard","nb","7187787778");
		phoneBook.add(new Contact1("a","b","ab","78083916438"));
		phoneBook.add(new Contact1("c","d","cd","36862546865"));
		//ask user who they want to remove assume they said cd
		//search through the array
		for(Contact1 c: phoneBook){
			if(c.getNickName().equals("cd")){  //a contact cant be comapred to a String so cant say c.equals("cd");
				phoneBook.remove(c);
				break; //if do a remove you must end the if
			}
		}
		//view a spacific contact
		for(Contact1 a: phoneBook){
			if(a.getNickName().equals("ab")){  //a contact cant be comapred to a String so cant say c.equals("cd");
				System.out.println(a); //this will call toString method of Contanct1
				break;
			}
		}
		//display all contact
		System.out.println(phoneBook); //this calls arrayList toString to display it and that toString will call the toString of contact1
		//change telephone number'
		for(Contact1 c: phoneBook){
			if(c.getNickName().equals("cd")){  //a contact cant be comapred to a String so cant say c.equals("cd");
				c.setPhoneNumber("1246535542");
				break; //if do a remove you must end the if
			}
		}
		//to display all last name
		for (int i = 0;i<phoneBook.size();i++){
			System.out.println(phoneBook.get(i));
		}
		
		
	}
}
