package sort;
import java.util.Scanner;
import java.io.*;

public class SchoolSupplies {

	public static void main(String[] args) {
		String[] adinaSupplies = new String[20]; //list of Adina’s supplies, adina is student 1
		String[] brachaSupplies = new String[20]; //list of Bracha’s supplies, bracha is student 2
		int adinaSupplyQty,brachaSupplyQty; //the method readInFile will return how mnay supplies each student has
		//read in and store each student’s list of supplies
		//read in and store Student 1's supplies
		String name="./supply_list_a.txt";
		int whoseKnapsack = 1; // keeps track of which student's knapsack the supplies are for
		adinaSupplyQty = readInFile(adinaSupplies,name,whoseKnapsack);
		//read in and store student 2's supplies
		whoseKnapsack++; //increment so that it goes to the next students's knapsack
		name = "./supply_list_b.txt";
		brachaSupplyQty = readInFile(brachaSupplies,name,whoseKnapsack);
									
		//find out and display what supplies both students have 
		sameSupplies(adinaSupplies, adinaSupplyQty, brachaSupplies, brachaSupplyQty);
					
		//find out what adina has that bracha does not and display them
		System.out.println("\nStudent 1 has the following supplies that Student 2 does not have: ");//i did not display the girl's names so that the program is more general and can be used for any two studetns
		mySpecialSupplies(adinaSupplies,adinaSupplyQty, brachaSupplies, brachaSupplyQty);
				    
		//find out and display which supplies Bracha has that Adina doesn’t have 
		System.out.println("\nStudent B has the following supplies that student A does not have: ");
		mySpecialSupplies(brachaSupplies, brachaSupplyQty, adinaSupplies,adinaSupplyQty);

				
		}
			
	/**
	 * read a file into array
	 * @param Supplies - array to read data into
	 * @param nameOfFile - the file name with extension
	 * @param whichStudent - says the which student's knapsack its up to
	 * @retrun amountOfSupplies - the amount of supplis the studetn has in her bag
	 */
	public static int readInFile (String[] Supplies, String nameOfFile, int whichStudent ){
		int amountOfSupplies=0; //keeps track of how many supplies are in the bag
		try{ //make sure the file can be found
			//the file was found
		Scanner input = new Scanner(new File(nameOfFile));
		System.out.println("Student "+ whichStudent+" supplies are:");
		while (input.hasNext())	{
					Supplies[amountOfSupplies]=input.nextLine();
					System.out.println(Supplies[amountOfSupplies]);
					amountOfSupplies++; 
				}
		input.close();	//close the scanner
		System.out.print("\n");      
		}
		catch (FileNotFoundException ex){
		//could not find the file, display an error message	
			System.out.println("missing data");
			System.exit(1);
		}
		//return the amount of supplies the student has in her bag
		return amountOfSupplies;
	}
	/**
	 * 
	 * @param suppliesOne  -first list of supplies
	 * @param oneQty       -quantity of significant values in the first list of supplies
	 * @param suppliesTwo  -second list of supplies
	 * @param twoQty       -quantity of significant values in second list of supplies
	 *
	 */
	public static void sameSupplies(String[] suppliesOne,int oneQty, String[] suppliesTwo, int twoQty ){
	    //determine which supplies are in BOTH list and display that list 
		//outer loop will go through each of the supplies in list one
		int bothQty =0; //keep track of how many supplies the both have
		String[] sameSuppliesList = new String[20] ; //contains only supplies in both knapsacks, it can not be more than 20 since there can only be 20 items per knapsack
		System.out.println("\nBoth girls have: ");
		for(int i = 0; i< oneQty; i++){ 
			//inner loop checks if any of the supplies in list two match the supply in list 1
			for(int a=0; a< twoQty; a++){
				if (suppliesOne[i].equalsIgnoreCase(suppliesTwo[a])){
					sameSuppliesList[bothQty]=suppliesOne[i];
					System.out.println(sameSuppliesList[bothQty]);
					bothQty++; 
				}
			}
		}
		//if there is nothing in common then bothQty will not have incremented and then tell user that they have nothing in common
		if (bothQty == 0){
			System.out.println(" nothing in common in there knapsacks");
		}
		
		
	}
	 /**
	   * 
	   * @param mySupplies  - list that contains set of values
	   * @param myQty       - quantity of values in the list 
	   * @param yourSupplies  - another list that contains a set of values
	   * @param yourQty     - quantity of significant values in the second list
	   * @return  -list that contains only those values that appear in first list but not in second
	   */
	public static void mySpecialSupplies(String[] mySupplies, int myQty, String[] yourSupplies, int yourQty){
			String[] mySuppliesOnly = new String[myQty];
			int myHas=0; //keep track of how many mySupplies has that yours does not
			//determine which supplies appear only in the first list but not in the second
									
			//outer loop goes through all adina's supplies 
			for(int i = 0; i< myQty; i++){ 
				//inner loop checks if any of the supplies in list two do not match the supply in list 1
				int amountNotSame=0; //this keeps track of how many elements in array two are not the same as array 1
				for(int a=0; a< yourQty; a++){
					if (!mySupplies[i].equalsIgnoreCase(yourSupplies[a])){
						 amountNotSame++;
						 //if the amount of elements in array two that are not the same is equal to all the elements in the array 
						 //then the element in array one that is being compared with array two is only in array one and not array two 
						 if (amountNotSame==yourQty){
							 mySuppliesOnly[myHas]=mySupplies[i];
							 System.out.println(mySuppliesOnly[myHas]);
							 myHas++; 
						 }
					} 
				}
			}
	}



}
	
