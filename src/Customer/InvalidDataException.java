package customer;

public class InvalidDataException extends Exception {
	public InvalidDataException(){
		super("Data input does not match required data");
	}

}
