package myfirstprogram;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class quiz2 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		String[] students = new String[20];

		String[][] booklist = new String[20][];

		int qtyStudents = 0; // start with zero students and add to the counter
								// each time a students name is entered

		students[0] = "Adina";

		qtyStudents++;

		students[1] = "Batya";

		qtyStudents++;

		students[2] = "Chana";

		qtyStudents++;

		students[3] = "Dina";

		qtyStudents++;

		students[4] = "Esther";

		qtyStudents++;

		students[5] = "Freida";

		qtyStudents++;

		// contains books read by some students

		booklist[0] = new String[] { "Frog and Toad", "Goose and Duck" };

		booklist[1] = new String[] { "Ramona the Pest", "See Me Run",
				"Penny and her Song" };

		booklist[3] = new String[] { "Odd Duck", "Ramona the Pest",
				"Penguin Troubles", "Penny and Her Marbles" };

		booklist[4] = new String[] { "Frog and Toad" };

		// 1. invoke method to display the names of the students

		displayNames(students, qtyStudents);

		// 2. invoke a method to display each student's name , alongside of
		// which display the books that the student read

		displayNamesAndBooksRead(students, qtyStudents, booklist);

		System.out
				.println("which student's reading list would you like to review?");

		String name = keyboard.next();

		// 3. invoke method to display the books that a specific student read

		String[] girlsbooks = new String[20];

		girlsbooks = getReadingList(name, students, booklist, qtyStudents);

		// 4. display the list of books read by the student with this specific ,
		// name

		// you know how many books there are based on the books[that girls
		// row].length, use that in for loop

		if (girlsbooks == null) {

			System.out.println("student didn't read any books");

		} else {

			for (int i = 0; i < qtyStudents; i++) {

				for (int j = 0; j < booklist[i].length; j++) {

					System.out.println(booklist[i][j]);

				}

			}

			// if the list is empty display message, 'student didn't read any
			// books'

			keyboard.close();

			System.out.println("\n\nHave a nice day");

			System.exit(0);

		}
	}

	/**
	 * 
	 *
	 * 
	 * @param names
	 *            - array that contains a list of names
	 * 
	 * @param qty
	 *            - now many values are in the array names[]
	 */

	public static void displayNames(String[] names, int qty) {

		// 5. display the significant data values that are stored in names[]

		for (int i = 0; i < qty; i++) {

			System.out.println("The girl in postiton " + (i + 1)
					+ " on the list is " + names[i]);

		}

	}

	/**
	 * 
	 *
	 * 
	 * @param names
	 *            - list of names of students
	 * 
	 * @param qty
	 *            - how many names are in the list of names[]
	 * 
	 * @param books
	 *            - the titles of each book read by each student who read a book
	 *            or books
	 */

	public static void displayNamesAndBooksRead(String[] names, int qty,
			String[][] books) {

		// 6. for each names in names[] display the name and the corresponding
		// list of books that were read by referencing

		// the corresponding position in books[][].

		// this method should display different data depending on what the
		// arrays, names[] and books[][]

		// contain at the time this method is invoked.

		// Based on the data that is currently stored in names[] and books[][]
		// the following output would be produced

		// Adina Frog and Toad Goose and Duck

		// Batya Ramona the Pest See Me Run Penny and her Song

		// Chana

		// Dina Odd Duck Ramona the Pest Penguin Troubles Penny and Her Marbles

		// Esther Frog and Toad

		// Freida

		for (int i = 0; i < qty; i++) { // go through each student

			System.out.print(names[i]); // show current students name

			// check if that colum was not instantiated

			try {

				// if the student does not have any books then go to the next
				// student if they do then show all the books

				if (books[i].length > 0) {

					for (int j = 0; j < books[i].length; j++) { // loop through
																// all the books
																// that the
																// student read

						System.out.print("\t" + books[i][j]); // on the same
																// line as name
																// show the
																// current
																// students
																// books

					}

				}

			}

			catch (NullPointerException e) {

				// if there were no books put in for the person then just go to
				// the next person

			}

			System.out.println();// go to next line after all books are showed.

		}

	}

	/**
	 * 
	 *
	 * 
	 *
	 * 
	 *
	 * 
	 * @param name
	 *            references the name of the student whose data will be
	 *            processed
	 * 
	 * @param names
	 *            references the list of names of students
	 * 
	 * @param bookList
	 *            list of books read by each student
	 * 
	 * @param qty
	 *            the number of students for which data has been stored
	 * 
	 * @return list of book titles read by the student with name stored in
	 *         parameter ,'name'
	 * 
	 *         return null if student didn't read any books
	 */

	public static String[] getReadingList(String name, String[] names,
			String[][] bookList, int qty) {

		// find the subscript of the girls whose name the user asked about

		int i;

		for (i = 0; i < qty; i++) {

			if (name.equalsIgnoreCase(names[i])) {

				break; // end the loop so that the value if i representst the
						// row in booklist that the info is stored on

			}

		}

		// get the books for that girls
		String[] requestedBooks = null;
		
			if (bookList[i].length == 0) {

				return null; // if no books were read by a specific student

			} else {

				for (int j = 0; j < bookList[i].length; j++) {

					requestedBooks = new String[bookList[i].length];

					requestedBooks[j] = bookList[i][j];

					return requestedBooks;

				}

			}
			return requestedBooks;
		}

		

	

}