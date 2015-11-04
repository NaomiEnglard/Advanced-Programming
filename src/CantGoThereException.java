package myfirstprogram;

public class CantGoThereException extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CantGoThereException(){
	  //The number the user entered is not a choice, enter number between 1-3
	  super();
	System.out.println("there is a marker in that spot please choose another spot");
	  
  }
}
