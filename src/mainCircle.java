package myfirstprogram;

public class mainCircle {
	public static void main(String[] args) throws NotSetException{
		//test program 
		//creates a stock object with symbol orcl, name oracle operation, 
		Stock firstStock = new Stock("URCL","oracle operation");
		//and previous closing price 34.5
		firstStock.setCurrentPrice(34.5);
		//set new current price to 34.35
		firstStock.setPreviousClosingPrice(34.35);
		//display the price-chagne percetnt
		double change = firstStock.getChangePercent();
		System.out.println(change);
	}
}
