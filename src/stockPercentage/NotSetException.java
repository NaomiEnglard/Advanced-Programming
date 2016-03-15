package stockPercentage;

public class NotSetException extends Exception {
	public NotSetException(){
		super ("The values have not been set up");
	}
}
