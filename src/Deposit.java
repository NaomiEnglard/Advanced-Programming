package myfirstprogram;

import java.util.GregorianCalendar;

public class Deposit {
	private double amountDeposited;
	private GregorianCalendar dayOfDeposit;


public Deposit(double amountToDeposit, GregorianCalendar day) {
	this.amountDeposited = amountToDeposit;
	this.dayOfDeposit =day;
}


public GregorianCalendar getDayOfDeposit() {
	return dayOfDeposit;
}


public double getAmountDeposited() {
	return amountDeposited;
}


}
