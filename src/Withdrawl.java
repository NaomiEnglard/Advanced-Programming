package myfirstprogram;

import java.util.GregorianCalendar;


public class Withdrawl {
		
		private double amountWithdrawl;
		private GregorianCalendar dayOfWithdrawl;
public Withdrawl(double amountToWithdrawl, GregorianCalendar day){
		this.amountWithdrawl = amountToWithdrawl;
		this.dayOfWithdrawl =day;
}
public double getAmountWithdrawl() {
		return amountWithdrawl;
}
public GregorianCalendar getDayOfWithdrawl (){
	return dayOfWithdrawl;
}

}
