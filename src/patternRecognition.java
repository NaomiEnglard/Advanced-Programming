package myfirstprogram;
import java.util.InputMismatchException;
import java.util.Scanner;
public class patternRecognition {

	public static void main(String[] args) {
		System.out.println("this program will find output if there are four of the same values in a row (horizontal,vertical, or diagnal");
		int length, width; //hold value of size of array
		String longR="rows", wide="colums"; 
		//ask user size of table
		length = size(longR);
		width= size(wide);
		//create array based on user's input
		int[][] table = new int[length][width]; //the table does not exist until user changes the size
		//ask user to fill in the table with numbers
		fillInTable(table);
		//display table
		showBoard(table);
		//find four in a row
		boolean fourInRow= false;
		//do not test to see if there are for in a row because the table is to small and its not possible
		if (length<4 && width<4);
		else{
			fourInRow=FindPattern(table,fourInRow,width);
		}
		if (fourInRow){
			System.out.println("\nThere are four in a row");
		}
		else{
			System.out.println("Sorry, there is not four in a row");
		}
				
		
		
	}
	/*
	 * ask user how of something they want and return the value
	 * @param grid = the array 
	 * @param type = the description of the item that they are inputting the size for
	 */
	//if a method should never comunicate with the user then i would have to right this part of the code twice, once by
	//rows an once by colums, is that better?
	public static int size(String type){  
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how many "+type+" do you want?");
		int value=keyboard.nextInt();
		return value;
	}
	/*
	 * get users input 
	 * @param grid = fill in grid with users input
	 */
	public static void fillInTable(int[][] grid){
		Scanner input = new Scanner(System.in);
		boolean inccorectInput = true;
		while (inccorectInput){
			inccorectInput=false;

		try{
			for (int r=0; r<grid.length; r++){
				System.out.println("enter the numbers that are in row "+(r+1));
				for (int c=0; c<grid[r].length; c++){
					System.out.println("spot "+(c+1));
					grid[r][c]=input.nextInt();
				}
			}
		}catch(InputMismatchException e){
			System.out.println("Input must be a number, try again");
			inccorectInput = true;
		}
		}
	}
	/*
	 * this method will display the table
	 * @param board = the two dimensional array
	 */
	public static void showBoard(int[][] Board) {
		for (int r = 0; r < Board.length; r++) {
			System.out.println();
			for (int c = 0; c < Board[r].length; c++)
				System.out.print(Board[r][c] + " \t ");
			}
		}
	/*
	 * find pattern of four in a row
	 * @param grid = the array holding values to search through
	 * @param outcome = is there four in a row
	 * @return outcome = true if there are four in a row and false if there are not
	 */
	public static boolean FindPattern (int[][] grid, boolean outcome,int numOfColums){
		//check horizontal
			outcome = horizontalTest(grid);
			if (outcome){ //if outcome is true return true
				return outcome;
			}
		//check vertical
			outcome = verticalTest(grid,numOfColums);
			if (outcome){ //if outcome is true return true
				return outcome;
			}
		//check diagonalls
			outcome = diagnal1Test(grid,numOfColums);
			if(outcome)
				return outcome;
			outcome = diagnal2Test(grid, numOfColums);
		return outcome;
	}
	/*
	 * test if there is four in a row horizontally
	 * @param grid = the array holding values to search through
	 * @return outcome = true if there are four in a row and false if there are not
	 */
	public static boolean horizontalTest(int[][] grid){
		for(int r=0; r<grid.length; r++){
			for (int c=0;c<(grid[r].length-3);c++){//a horizontal row of four cannot start in the last three colums there will not be enough room
				//if four horizontally are the same return true
				if(grid[r][c]==grid[r][c+1]&& grid[r][c]==grid[r][c+2]&& grid[r][c]==grid[r][c+3]){
					return true;
				}

			}
		}

		
		return false;
	}
	/*
	 * test if there is four in a row veritcally
	 * @param grid = the array holding values to search through
	 * @param numberOfColums = how many colums are there in the table
	 * @return outcome = true if there are four in a colum and false if there are not
	 */
	public static boolean verticalTest(int[][] grid, int numberOfColums){
	
		for(int r=0;r<(grid.length-3); r++){ //a row of four vertically cannot start in the bottom three arrays
			for(int c=0;c<grid[r].length; c++){
				//System.out.println(r); 				System.out.println(c);
				if(grid[r][c]==grid[r+1][c]&& grid[r][c]==grid[r+2][c]&& grid[r][c]==grid[r+3][c]){ //if four vertically are the same return true
					return true;
				}
			}
		}				
	return false;
	}
	/*
	 * check if there are four in a row for a positive slope diagnal line
	 * @param grid = the array holding values to search through
 	 * @param numberOfColums = how many colums are there in the table
	 * @return outcome = true if there are four in a diagnal and false if there are not 
	 */
	public static boolean diagnal1Test(int[][] grid,int numberOfColums){
		//start at row o colum 3 since there is not enough room to have four in a row diagnally before colum 3
		for(int r=0;r<(grid.length-3);r++){ //a diagnal of four will never start in the bottom 3 rows there is not enought room
			for(int c=3;c<grid[r].length;c++){//first three colums can not have a diagnal there is not room
				if(grid[r][c]==grid[r+1][c-1]&& grid[r][c]==grid[r+2][c-2]&& grid[r][c]==grid[r+3][c-3]){
					return true;
				}
			}
			}
			
		
		return false;
	}
	/*
	 * check if there are four in a row for a negaative slope diagnal line
	 * @param grid = the array holding values to search through
 	 * @param numberOfColums = how many colums are there in the table
	 * @return outcome = true if there are four in a diagnal and false if there are not 
	 */
	public static boolean diagnal2Test(int[][] grid, int numberOfColums ){
		//start at row o colum 3 since there is not enough room to have four in a row diagnally before colum 3
				for(int r=0;r<(grid.length-3);r++){ //a diagnal of four will never start in the bottom 3 rows there is not enought room
					for(int c=0;c<(grid[r].length-3);c++){//last three colums can not start a diagnal there is not room
						if(grid[r][c]==grid[r+1][c+1]&& grid[r][c]==grid[r+2][c+2]&& grid[r][c]==grid[r+3][c+3]){
							return true;
						}
					}
					}
		return false;
	}
	
}

	

