package findPattern;
import java.util.InputMismatchException;
import java.util.Scanner;
public class patternRecognition2 {

	private static final Exception InputMismatchException = null;
	public static void main(String[] args) {
		System.out.println("this program will find output if there are four of the same values in a row (horizontal,vertical, or diagnal");
		int length=0, width=0; //hold value of size of array
		//ask user size of table
		Scanner keyboard=new Scanner(System.in);
		boolean incorrectInput=false;
		do{
		try{
		incorrectInput=false;
		System.out.println("how many rows do you want?");
		length=keyboard.nextInt();
		System.out.println("how many colums do you want?");
		width=keyboard.nextInt();
		}catch(InputMismatchException e){
			System.out.println("please re-enter the rows and colums as a number value");
			//empty the keyboard buffer so that is does not hold the incorrect input that the user put in
			keyboard.nextLine(); 
			incorrectInput=true;
		}
		}while(incorrectInput);
		//create array based on user's input
		int[][] table = new int[length][width]; //the table does not exist until user changes the size
		//ask user to fill in the table with numbers
		try{
			fillInTable(table);
		}catch(InputMismatchException e){
			System.out.println("Input must be a number, try again");
			//send user back to method to try again
			fillInTable(table);
		}
		//display table
		showBoard(table);
		//find four in a row
		boolean fourInRow= false;
		//do not test to see if there are for in a row because the table is to small and its not possible
		if (length<4 && width<4);
		else{//if there are four in a row make the boolean true
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
	 * get users input 
	 * @param grid = fill in grid with users input
	 */
	//?should this be in main since it talks to the user? or is it okay since that is what the job of the method is?
	public static void fillInTable(int[][] grid) throws InputMismatchException{
		Scanner input = new Scanner(System.in);
		for (int r=0; r<grid.length; r++){
				System.out.println("enter the numbers that are in row "+(r+1));
				for (int c=0; c<grid[r].length; c++){
					System.out.println("spot "+(c+1));
					grid[r][c]=input.nextInt();
				}
			}
		input.close();
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

	

