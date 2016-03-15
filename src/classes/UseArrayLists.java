package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class UseArrayLists {
	
	public static void main(String[] args)
	{
		//instantiate an instance of ArrayList
		//ArrayList constructor decides on a capacity of 10
		//this means there will be 10 positions into which we can add data initially
		//when that space is exhausted the ArrayList will automatically resize itself
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		ArrayList<Integer> yourList = new ArrayList<Integer>(20);
		
		//getters -- accessors  provide data to the user of that class
		//how big is the ArrayList
		System.out.println("myList contains: " + myList.size() + " values");
		
		//myList.get(0); //retrieve data that was stored in a specific position
		
		
		//setters -- mutators
		//designed to modify the data stored in a class
		//myList.set(0, 100);
		
		myList.add(100); 	//places the value 100 in the next available position
							//adds 1 to size
		
		System.out.println("current size " + myList.size());
		
		myList.add(200);
		System.out.println("current size " + myList.size());
		
		myList.set(0, 1000);
		System.out.println("current size " + myList.size());
		
		//display contents of ArrayList
		//method 1
		for (Integer value : myList)
		{
			System.out.println(value);
		}
		
		//method 2
		for (int i = 0; i < myList.size(); i++)
		{
			System.out.println(myList.get(i));
		}
		
		//method 3
		System.out.println(myList.toString());
		
		Book aBook = new Book("Hang on tight", 100.00);
		Book anotherBook = new Book ("You will Succeed", 200.00);
		
		ArrayList<Book>books = new ArrayList<Book>();
		
		books.add(aBook);
		books.add(anotherBook);
		
		System.out.println(books);
		
		
		GregorianCalendar today = new GregorianCalendar();
		
		//getters - return data stored in the instance
		System.out.println("Month is " + ( today.get(Calendar.MONTH) + 1));
		
		System.out.println("Day of the Week " + today.get(Calendar.DAY_OF_WEEK));
		
		System.out.println(today);
		
		SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
		
		System.out.println(
		formatter.format(today.getTime()));
		
		today.add(Calendar.DATE , 1);
		
	}

}
