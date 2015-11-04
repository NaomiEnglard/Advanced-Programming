public static void main(String[] args) {
		Scanner gradeFile;  //will reference the text file that records the test scores
		int[] grades;       //will reference the array that stores the test scores that were read in
		int numberOfScores;  //how many scores are in the file
		try{  
		    //if file can't be found on the disk , the OS will send back a message to the JVM
		    //java will throw an exception to alert the application that an error condition has occurred
		    //Note: this will work if the testScores.txt file is stored in the same folder as this
			//program is executing  -  you can specify a specific path if you are unsure as to where to
			//store the file
			gradeFile = new Scanner (new File ("./testScores.txt"));
		    
		    
		    
		    
		
		
		

	    }
		//catch the Exception that has been thrown - display a message to the end user 		
		catch(FileNotFoundException ex){
			System.out.println("data could not be processed - file not found");
		}
		}
