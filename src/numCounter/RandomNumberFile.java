package numCounter ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomNumberFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		PrintWriter outputFile = new PrintWriter (new File ("randomNumbers.txt"));
		Random randomGen = new Random();  //to generate a random number
		int value ; //to store the number temporarily
		for (int i=0;i<100;i++){
			//generate a number between 0 and 100, will include 0 and exclude 100
			//add 1 so the number will end up being a value  from 1 to 100
			//Store the result in memory location , 'value'
			value = randomGen.nextInt(100)+1;
			//write out the data in 'value' to the file , follow the data with a blank space
			outputFile.printf("%d ",value);
		}
		outputFile.close();  //job is done , close the file
		System.out.println("random number file has been generated");
		}
		catch(FileNotFoundException ex){
			System.out.println("couldnt generate file - contact IT");
		}
		

	}

}
