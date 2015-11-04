package myfirstprogram;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class NeyKnapsackCompare {
	

	public static void main(String[] args) {
		int adinaSupplyQty =0;    //how many supplies Adina has in her knapsack
		int brachaSupplyQty=0;    //how many supplies Bracha has in her knapsack
		String[] adinaSupplies = new String[20]; //list of Adina’s supplies
		String[] brachaSupplies = new String[20]; //list of Bracha’s supplies

		Scanner read; //used to read the files with the supplies
		
		try{
		  //read in and store each student’s list of supplies
			read = new Scanner (new File("./AdinaSupplies.txt")); //making connection with the first files
			int index; //to be used in the loops
			for(index=0; read.hasNext(); index++){
				adinaSupplies[index]=read.nextLine();
				adinaSupplyQty+=1;
			}//end for 
			read.close(); //close first file
			
			read = new Scanner (new File("./BrachaSupplies.txt")); //making connection with the second file
			for(index=0; read.hasNext(); index++){
				brachaSupplies[index]=read.nextLine();
				brachaSupplyQty+=1;
			}//end for
			read.close(); //close second file
               // find out which supplies both students have in their knapsacks
		  String[] matchingSupplies = 
           sameSupplies (adinaSupplies, adinaSupplyQty, brachaSupplies, brachaSupplyQty);
		
		  //display the supplies both students have in their knapsack
			System.out.println("Adina and Bracha both have: ");
			for(String val:matchingSupplies)
				System.out.println(val);
			
                 
          //find out which supplies Adina has that Bracha doesn’t have
			String[] adinaSuppliesOnly = mySpecialSupplies(adinaSupplies, adinaSupplyQty, brachaSupplies, brachaSupplyQty);
			//display the supplies that Adina has that Bracha doesn’t have 
			System.out.println("Only Adina has:");
			for(String val:adinaSuppliesOnly)
				System.out.println(val);
		  //find out which supplies Bracha has that Adina doesn’t have  
			String[] brachaSuppliesOnly = mySpecialSupplies(brachaSupplies, brachaSupplyQty, adinaSupplies, adinaSupplyQty);
            //display the supplies that Bracha has that Adina doesn’t have
			System.out.println("Only Bracha has:");
			for(String val:brachaSuppliesOnly)	
				System.out.println(val);
		}//end try
		
		catch (FileNotFoundException ex){
			System.out.println("missing data");
			System.exit(1);
		}//end catch
		
	}//end main 
	


      /**
	 * 
	 * @param suppliesOne  -first list of supplies
	 * @param oneQty       -quantity of significant values in the first list of supplies
	 * @param suppliesTwo  -second list of supplies
	 * @param twoQty       -quantity of significant values in second list of supplies
	 * @return             -list that includes only those values that appear in both lists 
	 */
	public static String[] sameSupplies(String[] suppliesOne,int oneQty, String[] suppliesTwo, int twoQty ){
		String[] sameSuppliesList;
		if(oneQty<twoQty)  //I don't know how long it has to be but I know for sure the length will not be longer than the shortest list
			sameSuppliesList=new String[oneQty];
		else
			sameSuppliesList=new String[twoQty];
           //determine which supplies are in BOTH list and return a list that
           //contains only those supplies 
		int x=0; //for calculating subscript of suppliesOne
		int y=0; //for calculating the subscript of sameSuppliesList
		boolean okay; //used with sequentialSearch method
		String fromListOne;//to reference the string name of the supply
		while(x<oneQty){
			fromListOne = suppliesOne[x];
			okay= sequentialSearch(fromListOne, suppliesTwo, twoQty);
			if(okay==true){
				sameSuppliesList[y]=fromListOne;
				y++;
			}//end if
			x++;
		}//end while	

			return sameSuppliesList;
	}//end same supplies
	
	
 /**
   * 
   * @param mySupplies  - list that contains set of values
   * @param myQty       - quantity of values in the list 
   * @param yourSupplies  - another list that contains a set of values
   * @param yourQty     - quantity of significant values in the second list
   * @return  -list that contains only those values that appear in first list but not in second
   */
	public static String[] mySpecialSupplies(String[] mySupplies, int myQty, String[] yourSupplies, int yourQty){
		String[] mySuppliesOnly = new String[myQty];
		
            //determine which supplies appear only in the first list but not in the second
		int x=0; //for calculating subscript of mySupplies
		int y=0; //for calculating the subscript of mySuppliesOnly
		boolean okay; //used with sequentialSearch method
		String fromMyList;//to reference the string name of the supply
			while(x<myQty){
				fromMyList = mySupplies[x];
				okay= sequentialSearch(fromMyList, yourSupplies, yourQty);
				if(okay==false){
					mySuppliesOnly[y]=fromMyList;
					y++;
				}//end if
				x++;
			}//end while	



            //return the list of supplies that appear in the first list but not in the second 
	    return mySuppliesOnly;
	}//end mySpecialSupplies

 /**
	@param toCompare - String that will be compared to the array values to see if the array has it
	@param supplyList - the array in which we are making a search
	@param qty - quantity of values in the array
*/	

	public static boolean sequentialSearch(String toCompare, String[] supplyList, int qty){
		boolean okay=true;
		for(int i=0; i<qty; i++){
			if(toCompare.equalsIgnoreCase(supplyList[i])){
				okay=true;
				return okay;
			}//end if	
			else
				okay=false;
		}//end for
			
			return okay;
	}//end sequentialSearch		
}






