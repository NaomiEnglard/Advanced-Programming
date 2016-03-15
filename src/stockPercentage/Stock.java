package stockPercentage;

import bank.InvalidDataException;

public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;
	//no arg constructor
	public Stock(){
		this("Ex","Example");	
	}
	//constructor that creates a stock with the specifiees symbol and name
	public Stock(String sign, String title){
		this.symbol=sign;
		this.name=title;		
		this.previousClosingPrice =-1;
		this.currentPrice=-1;
	}
	//set previous and current price
	public void setPreviousClosingPrice(double previousPrice)throws InvalidDataException {
		if(previousPrice<0){//if less than 0
			throw new InvalidDataException();
		}else{
			this.previousClosingPrice = previousPrice;
		}
	}
	public void setCurrentPrice(double price)throws InvalidDataException {
		if(price<0){// if less than 0
			throw new InvalidDataException();
		}
		else{
			this.currentPrice = price;
		}
	}
	//meathod getChangePercent() that returns percent chagned form previous to current
	public double getChangePercent()throws NotSetException {
		if(previousClosingPrice<0 || currentPrice<0){ //if they try to get percent change b4 they sue seters
			throw new NotSetException();
		}else{
		double percnetChange = (Math.abs(this.currentPrice - this.previousClosingPrice)/this.previousClosingPrice)*100;
		return percnetChange;
		}
	}
	//
}
