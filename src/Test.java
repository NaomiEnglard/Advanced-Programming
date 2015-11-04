package myfirstprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner gradeFile;// scanner to read from file
		try {
			// if file can't be found on the disk , the OS will send back a
			// message to the JVM
			// java will throw an exception to alert the application that an
			// error condition has occurred
			// Note: this will work if the testScores.txt file is stored in the
			// same folder as this program is executing - you can specify a
			// specific path if you are unsure as to where to
			// store the file
			gradeFile = new Scanner(new File("./testScores.txt"));
			int numberOfScores = gradeFile.nextInt();
			int[] grades = new int[numberOfScores];// create an array with the
													// space to fit the guess of
													// the amount of elements in
													// the file
			while (gradeFile.hasNext()) {// assign each number in a text
											// document to an element in an
											// array
				for (int i = 0; i <= numberOfScores; i++) {
					grades[i] = gradeFile.nextInt();
				}
			}
			System.out.println("There are " + numberOfScores + " scores");
			int highestScore = bestScore(grades);// call method to find the best
													// score
			char letterGrade;
			int value;
			for (int i = 0; i < numberOfScores; i++) {
				value = grades[i];
				letterGrade = getGrade(value, highestScore); // calculate
																// students
																// grade ?have
																// to send it
																// something to
																// be assigned
																// score not
																// sure what
				System.out.println("The " + (i + 1) + " score is " + grades[i]
						+ " and the grade is" + letterGrade);
			}
		}
		// catch the Exception that has been thrown - display a message to the
		// end user
		catch (FileNotFoundException ex) {
			System.out.println("data could not be processed - file not found");
		}
	}

	/**
	 * This method will find the best grade
	 * 
	 * @param scores
	 *            array of test scores
	 * @return the value of the best score that appears in the array, scores
	 */
	public static int bestScore(int[] scores) {
		int high = 0; // this will be assigned the high score
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > high) // each grade that is higher that all previes
									// scores will be assigned to value high
			{
				high += scores[i];
			}
		}
		return high;
	}

	/**
	 * Give the student a grade based thier score and the highest score
	 * 
	 * @param score
	 * @param bestScore
	 *            value of the best score achieved on this particular
	 *            test/exercise
	 * @return letter grade awarded to the score
	 */
	public static Character getGrade(int score, int bestScore) {
		char grade; // the letter that represents the students grade
		if (score >= (bestScore - 10))
			grade = 'A';
		else if (score >= (bestScore - 20))
			grade = 'B';
		else if (score >= (bestScore - 30))
			grade = 'C';
		else if (score >= (bestScore - 40))
			grade = 'D';
		else
			grade = 'F';
		return grade;
	}

}