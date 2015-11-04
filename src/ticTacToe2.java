package myfirstprogram;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ticTacToe2 {

	public static void main(String[] args) {
		// welcome message
		System.out
				.println("WELCOME to tic-tac-toe, this is a two person game. \nOne user is  x and the other is o. \nTake turns trying to get a whole row, clomum, or diagnal of your marker.");
		String whoseTurn = "x"; // keep track of whose turn it is by changing
								// between x and o
		String[][] gameBoard = new String[3][3]; // 2d array to hold where users
													// go
		boolean win = false; // if win is false users will keep having turns
		boolean filled = false; // if the board is full filled will become true
								// and users will not be able to have another
								// turn
		int spotsFilled = 0; // keep track of how many spots on the board are
								// full, to see if the board is full
		// prepare the board and show it
		getBoardReady(gameBoard);
		showBoard(gameBoard);
		// let user take turns going until the board is full or someone wins
		boolean incorrectInput = true;
		do {
			while (incorrectInput) { //user keeps going while input is incorrect
				try {
					incorrectInput=false;
					Turn(gameBoard, whoseTurn);
				} catch (ArrayIndexOutOfBoundsException ex) {
					System.out.println("Enter a number between 1-3 for the rows and colums value, try again");
					// allow user to go again
					incorrectInput=true;
				} catch (InputMismatchException ex1) {
					System.out.println("you did not enter a number, try again");
					// allow user to go again
					incorrectInput=true;
				} catch (CantGoThereException ex2) {
					incorrectInput=true;

				}
			}
			incorrectInput=true;
			showBoard(gameBoard);
			spotsFilled++;// after each users turn another spot is filled so
							// increment spotsFilled counter
			win = checkWinner(gameBoard); // check if there is a winner
			filled = fullBoard(spotsFilled);// check if board is full and no
											// winner
			whoseTurn = SwitchUsers(whoseTurn); // switch between x and o
		} while (win == false && filled == false);
		endStatment(win, filled, whoseTurn);
	}

	/*
	 * make an empty board
	 * 
	 * @param board = the playing board
	 */
	public static void getBoardReady(String[][] board) {
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				board[r][c] = " ";
			}
		}
	}

	/*
	 * this method allows a user to pick where to put his marker
	 * 
	 * @param gameBoard = array that holds game board positions
	 * 
	 * @param whoseTurn = keeps track of whose turn it is, x or 0
	 */
	public static void Turn(String[][] board, String whoseTurn)
			throws ArrayIndexOutOfBoundsException, InputMismatchException,
			CantGoThereException {
		// ask user where they would like to put their marker
		Scanner choice = new Scanner(System.in);
		int rowChoice = -1, columChoice = -1;
		System.out.print("choose a row: 1,2, or 3 for player " + whoseTurn);
		rowChoice = choice.nextInt();
		System.out.print("choose a colum: 1,2, or 3 for player "+ whoseTurn);
		columChoice = choice.nextInt();

		// only allow someone to go in a spot that no one else is in, the
		// spot is one less than the person enters since
		// arrays start at 0 and the person's choice start at 1
		if ((board[rowChoice - 1][columChoice - 1].equalsIgnoreCase(" "))) {
			// an x or o should be filled into the user's choice
			board[rowChoice - 1][columChoice - 1] = whoseTurn;
		} else { // if there is a marker in the spot error there is someone
				// already there allow them to read in again
			throw new CantGoThereException();
		}

	}

	/*
	 * this method will display the board with the current markers
	 * 
	 * @param playingboard = the two dimensional array that has the markers
	 * stored in it
	 */
	public static void showBoard(String[][] playingBoard) {
		System.out.println("____________");
		for (int r = 0; r < playingBoard.length; r++) {
			System.out.print("| ");
			for (int c = 0; c < playingBoard[r].length; c++)
				System.out.print(playingBoard[r][c] + " | ");
			System.out.println("\n_____________");
		}
	}

	/*
	 * this method will switch the counter that keeps track of whose turn it is
	 * 
	 * @param XorO = counter that keeps track of whose turn it is
	 * 
	 * @return XorO = updated counter
	 */
	public static String SwitchUsers(String XorO) {
		if (XorO.equalsIgnoreCase("x")) { // if x just went
			XorO = "o"; // switch to o's turn
		} else { // if o just went make it x's turn
			XorO = "x";
		}
		return XorO;
	}

	/*
	 * check if the person who just went is a winner
	 * 
	 * @param grid = the game board
	 * 
	 * @return winner = true if person won, false if they lost
	 */
	public static boolean checkWinner(String[][] grid) {
		boolean winner = false;
		// check if any of the rows have all the same letter
		for (int r = 0; r < grid.length; r++) {
			// cheack if all three rows have are the same, but not empty
			if (!grid[r][0].equals(" ") && grid[r][0].equals(grid[r][1])
					&& grid[r][0].equals(grid[r][2])) {
				winner = true;
				return winner;
			}
		}
		// any colum has all the same x
		for (int c = 0; c < grid.length; c++) {
			// check if any row has all the same markers, and is not empty
			if (!grid[0][c].equals(" ") && grid[0][c].equals(grid[1][c])
					&& grid[0][c].equals(grid[2][c])) {
				winner = true;
				return winner;
			}

		}
		// check if diagnals have same values
		if (grid[1][1].equals(" ")) { // if the middle value is not filled then
										// both diagnals can not be filled with
										// the same marker
			return winner;
		}
		// diagnal 1
		if (grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) {
			winner = true;
			return winner;
		}
		// diagnal 2
		if (grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0])) {
			winner = true;
			return winner;
		}
		// if winner did not become true then return winner here
		return winner;
	}

	/*
	 * check to see if the board is full (of a 3*3 board)
	 * 
	 * @param couter = used to keep track of how many spaces in the board are
	 * used
	 */
	public static boolean fullBoard(int counter) {
		boolean full = false;
		// System.out.println(counter);
		if (counter == 9) { // there are 9 spots on the board
			full = true;

		}
		// return true if the board is true and false if the board is not full
		return full;
	}

	/*
	 * output reason for end of game
	 * 
	 * @param threeInARow =bolean expresion that says if somone won
	 * 
	 * @param allFull = boolean expression that says if board if full
	 * 
	 * @param turn = whose turn it is
	 */
	public static void endStatment(boolean threeInARow, boolean allFull,
			String turn) {
		if (threeInARow) { // if three in a row is true then the game ended
							// because someone won
			// after winner won switch user's method was called so turn is
			// holding the wong winner
			turn = SwitchUsers(turn); // change back to the winner's turn
			System.out.println("player " + turn + " wins!!!!!");

		} else if (allFull) {// if all full is true the game ended because the
								// board is full
			System.out.println("No winner, the board is full");

		}

	}

}
