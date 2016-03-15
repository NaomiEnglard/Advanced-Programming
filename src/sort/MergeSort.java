package sort;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MergeSort {
	public static void main(String[] args) {
		// read data from two text files into two arrays
		int[] listA = new int[20]; // an array to store values of the first
		int[] listB = new int[20]; // array to store values of second list
		int amountA = 0, amountB = 0; // keeps track of how many elements are
										// read into each array

		// read in list 1
		String nameOfFile = "./numList1.txt";
		amountA = IntFileToArray(listA, nameOfFile); // read in the data and
														// return the number of
														// items read in
		System.out.println("List A of unsorted numbers:");
		displayIntElementsInArray(listA, amountA);

		// read in list 2
		nameOfFile = ("./numList2.txt");
		amountB = IntFileToArray(listB, nameOfFile);
		System.out.println("List B of unsorted numbers:");
		displayIntElementsInArray(listB, amountB);
		// sort list1
		sortArrayOfInts(listA, amountA);
		System.out.println("List A sorted:");
		displayIntElementsInArray(listA, amountA);
		// sort list2
		System.out.println("List B sorted:");
		sortArrayOfInts(listB, amountB);
		displayIntElementsInArray(listB, amountB);
		// find what is in both lists
		int[] bothSets = new int[amountA + amountB];
		int bothSize = intersectSet(listA, amountA, listB, amountB, bothSets);
		System.out.println("both lists have:");
		// if 0 elements were read into bothSets array then they have nothing in
		// common
		if (bothSize == 0) {
			System.out.println("nothing in common");
		} else { // if they have something in common display what it is
			displayIntElementsInArray(bothSets, bothSize);
		}
		// merge both sets
		int[] mergedListAB = new int[amountA + amountB];
		int mergeSize = mergeLists(listA, amountA, listB, amountB, mergedListAB);
		System.out.println("Both lists merged are:");
		displayIntElementsInArray(mergedListAB, mergeSize);
	}

	/*
	 * This method will integers from a file into an array
	 * 
	 * @param arrayName = the array you want the file to store the data in
	 * 
	 * @param fileName = the name of the file being read in
	 * 
	 * @return arraySize = return how many spaces are filled in the array
	 */
	public static int IntFileToArray(int[] arrayName, String fileName) {
		int arraySize = 0; // keep track of how many elements are read into the
							// array
		// make sure the file can be found
		try {
			Scanner input = new Scanner(new File(fileName));
			while (input.hasNext()) {
				if (arraySize < arrayName.length) { // only read file if there
													// is room left in the array
					arrayName[arraySize] = input.nextInt();
					arraySize++; // increment the index so the next element will
									// be read into the next spot in the array
				}
			}
			input.close();
		} catch (FileNotFoundException ex1) {
			System.out.println("file not found");
			System.exit(1);
		}

		return arraySize;
	}

	/*
	 * this method sorts a array that stores a list of ints
	 * 
	 * @param unsorted = array of unsorted numbers
	 * 
	 * @param qty = the amount of elements used in the array
	 */
	public static void sortArrayOfInts(int[] unsorted, int qty) {
		// bubble sort
		int tempHolder = 0; // hold the number that is being read in
		boolean swapped;
		do {
			swapped = false;
			for (int index = 0; index < qty - 1; index++) {
				if (unsorted[index] > unsorted[index + 1]) {
					tempHolder = unsorted[index];
					unsorted[index] = unsorted[index + 1];
					unsorted[index + 1] = tempHolder;
					swapped = true;
				}
			}

		} while (swapped);

	}

	/*
	 * println all elements in an array
	 * 
	 * @param display = the array which you want to display the elements of
	 * 
	 * @param amntOfElements = the number of elements that should be displayed
	 */
	public static void displayIntElementsInArray(int[] display,
			int amntOfElements) {
		for (int i = 0; i < amntOfElements; i++) {
			System.out.println(display[i]);
		}
	}

	/*
	 * this method finds what numbers are in both lists
	 * 
	 * @param firstList = the array of one list
	 * 
	 * @param qtyOfFirst = the amount of elements in list 1
	 * 
	 * @param secondList = the array of the second list
	 * 
	 * @param qtyOfSecond = the amount of elements in list 2
	 * 
	 * @param bothListsHave = an array to store the values that are in both
	 * lists
	 * 
	 * @return counter = amount of elements in the bothListsHave array
	 */
	public static int intersectSet(int[] firstList, int qtyOfFirst,
			int[] secondList, int qtyOfSecond, int[] BothListsHave) {
		int firstCounter = 0, secondCounter=0, bothCounter =0; //track where in the array computer is up to
		int valueFirst, valueSecond; //hold the value that is being compared in the first and second list
		//begin the loop iff both first and second list have values that have not been comparted
		while (firstCounter<qtyOfFirst && secondCounter<qtyOfSecond){
			//each time the loop iterates the values should be updated
			valueFirst=firstList[firstCounter];
			valueSecond=secondList[secondCounter];
			//if values are equal assing to bothListsHave array
			if(valueFirst == valueSecond){
				BothListsHave[bothCounter]=valueFirst;
				bothCounter++;
				firstCounter++; // if a counter goes above the value of elements in array the loop will stop iterating when it reaches the while
				secondCounter++;
			}
			//if the number from first list is less than number in the second list
			else if(valueFirst<valueSecond){
				firstCounter++; //increment the first since it is not the same as the value from the second list and it is lower than the lowest value in the second list so it is not the same as any value in the second list
			}
			//if the number from the second list is less than the number in the first list
			else{
				secondCounter++;; //increment since its lower than all values in the first list(since the last equal number) and therfore is not the same as an value in the first list
			}
		}
	   // return the amount of elements read into the array
		return bothCounter;
	}

	/*
	 * Merge two lists into one list in number order
	 * 
	 * @param listOne = first list
	 * 
	 * @param qtyOne = amount of elements in list one
	 * 
	 * @param listTwo = second list
	 * 
	 * @param qtyTwo = amount of elements in list Two
	 * 
	 * @return mergeCounter = return size of merge array
	 */
	public static int mergeLists(int[] listOne, int qtyOne, int[] listTwo,
			int qtyTwo, int[] merged) {
		int oneCounter = 0, twoCounter = 0, mergeCounter = 0;
		int valueOne = 0, valueTwo = 0;// hold value of the element in the
										// coresponding lists that are about to
										// be put in merge
		/*
		 * boolean listAEmpty, listBEmpty; //if list one has more elements that
		 * were not put in merge if (oneCounter<qtyOne){ valueOne =
		 * listOne[oneCounter]; //valueOne holds the value of the element in
		 * listOne you are up to listAEmpty = false; } else{ listAEmpty = true;
		 * } //if the second list has more elements that were not put in merge
		 * if (twoCounter< qtyTwo){ valueTwo= listTwo[twoCounter];
		 * listBEmpty=false;
		 * 
		 * } else{ listBEmpty= true; }
		 */
		// if both elements have more elements that were not put in merge array
		// continue
		while (oneCounter < qtyOne && twoCounter < qtyTwo) {
			// each time the loop loops the value of one and two should be
			// updated based on the counters current location in the array
			valueOne = listOne[oneCounter];
			valueTwo = listTwo[twoCounter];
			// if the values of A and B are equal assign one of them to merge
			// and then change counter of both
			if (valueOne == valueTwo) {
				merged[mergeCounter] = valueOne;
				mergeCounter++;
				oneCounter++; // if the counters get incremented to a value
								// higher than the amount of elements in the
								// array
				twoCounter++; // then they will be caught by the while loop and
								// it will not be a problem
			}
			// the lower value should be put into merge array
			else if (valueOne < valueTwo) {
				merged[mergeCounter] = valueOne;
				mergeCounter++;
				oneCounter++;
			}
			// if value one is greater than value two then put value two into
			// the merge array
			else {
				merged[mergeCounter] = valueTwo;
				mergeCounter++;
				twoCounter++;
			}

		}
		// check if list One has more elements that were not read into the merge
		// and put them all in merge array
		while (oneCounter < qtyOne) {
			// they are all higher than the highest element in list two since
			// listTwo used all its elements if the previeous while loop
			valueOne = listOne[oneCounter];
			merged[mergeCounter] = valueOne;
			mergeCounter++;
			oneCounter++;
		}
		// check if list two has more elemnts that were no read into the merge
		// and put them all int merge array
		while (twoCounter < qtyTwo) {
			// all the values left in list two are higher than the highest value
			// in list one, since all the values in list one were put in merged
			// array already
			valueTwo = listTwo[twoCounter];
			merged[mergeCounter] = valueTwo;
			mergeCounter++;
			twoCounter++;
		}
		// all values are in the merged array
		return mergeCounter; // if the last element in list are equal then merge
								// will be one higher than neccessary??
	}
}
