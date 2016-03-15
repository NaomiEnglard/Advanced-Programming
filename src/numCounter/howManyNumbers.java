package numCounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class howManyNumbers {
	public static void main(String[] args)
	{
	int[] allNumbers= new int[100]; //an array with 100 elements one for  each number between  1-100
	//read in number from file
	try {//file found
		int holdTemporaryValue=0; //hold the value that is being read in
		Scanner input = new Scanner(new File("./randomNumbers.txt"));
		while(input.hasNext()){
			holdTemporaryValue = input.nextInt();
			//System.out.println(holdTemporaryValue);
			if(!(holdTemporaryValue==0));{ //the last number is zero and does not get included in the amount of each number 
			//increment the element in the array that is one lower than the value read in (since array's start from 0 not1)
			allNumbers[(holdTemporaryValue-1)] +=1;	
			}
		}
		input.close();
	} 
	catch (FileNotFoundException ex) {
		//file not found
		System.out.println("can not find file");
		System.exit(1);	
	}
	//display results
	for(int i =0; i<100; i++){
		if(allNumbers[i]==1){
			System.out.println((i+1)+" occurs "+allNumbers[i]+" time");
		}
		else if(allNumbers[i]>1){
			System.out.println((i+1)+ " occurs "+allNumbers[i]+" times");
		}
		else if (allNumbers[i]==0){
			System.out.println((i+1)+ " never occurs");
		}
		
	}
	}
}
	
	
	

