package bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Account {

	private int id;
	private double initailBalance;
	private static double annualInterestRate;
	private GregorianCalendar dateCreated;
	// private static int lastID=0;
	private ArrayList<Deposit> depositList;
	private ArrayList<Withdrawl> withdrawlList;

	// constructor
	// public Account(){
	// this(++lastID,0.0);
	// }
	public Account(int userId, double userBalance) throws InvalidDataException {
		// if(userId<lastID)//if they enter an id less than 0, or an id that an
		// account has a new account should not be created
		// throw new InvalidDataException();
		// else
		this.id = userId;
		if (userBalance < 0)
			throw new InvalidDataException();
		else
			this.initailBalance = userBalance;
		this.annualInterestRate = 0.0;
		this.dateCreated = new GregorianCalendar();
		this.depositList = new ArrayList<Deposit>();
		this.withdrawlList = new ArrayList<Withdrawl>();

	}

	// why do we let them change the id, balance...????
	public int getId() {
		return id;
	}

	private void setId(int id) {// the user should not be able to set the id of
								// his account
		this.id = id;
	}

	public Calendar getDateCreated() {
		GregorianCalendar sender = new GregorianCalendar();
		sender.set(this.dateCreated.get(Calendar.YEAR),
				this.dateCreated.get(Calendar.MONTH),
				this.dateCreated.get(Calendar.DAY_OF_MONTH));
		return sender;
	}

	public double getBalance() {
		double total = this.initailBalance;
		// add the deposits to the inital balance
		for (Deposit payment : depositList) {
			total += payment.getAmountDeposited();
		}// remove withdrawals from the total balance
		for (Withdrawl debt : withdrawlList) {
			total -= debt.getAmountWithdrawl();
		}
		return total;
	}

	public double getBalanceAsOf(GregorianCalendar date) {
		double totalAsOfDate = this.initailBalance;
		// add the deposits to the initial Balance if they are before or equal
		// to the date provided
		for (Deposit payment : depositList) {
			if (date.before(payment.getDayOfDeposit())
					|| date.equals(payment.getDayOfDeposit())) {
				totalAsOfDate += payment.getAmountDeposited();
			}
		}// remove withdrawls from the total balance if they are made before at
			// the time provided
		for (Withdrawl debt : withdrawlList) {
			if (date.before(debt.getDayOfWithdrawl())
					|| date.equals(debt.getDayOfWithdrawl())) {
				totalAsOfDate -= debt.getAmountWithdrawl();
			}
		}
		return totalAsOfDate;

	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		// although a user should not be able to set his Interst Rate, this
		// progam requires it so it is public method
		this.annualInterestRate = annualInterestRate;
	}

	// method to return monthly intrest rate
	public double getMonthlyInterstRate() {
		double MonthlyIR = (this.annualInterestRate / 120); // devide by 120 b/c
															// u need to devide
															// by 12 for monthly
															// rate and by 100
															// to get rid of the
															// percent
		return MonthlyIR;
	}

	// metho to get mothly insterst
	public double getMonthlyInterst() {
		double interst = (getMonthlyInterstRate()) * this.getBalance();
		return interst;
	}

	// method to withdraw money
	public double withdraw(double amountToWithdraw)
			throws InsufficientFundsException {
		// this.balance-=amountToWithdraw;
		if (amountToWithdraw < 0 || amountToWithdraw > this.getBalance())
			// if the user puts in a negative number or a withdraw amount
			// greater than their balance thorw error
			throw new InsufficientFundsException();
		GregorianCalendar dayOfWithdrawl = new GregorianCalendar();
		this.withdrawlList.add(new Withdrawl(amountToWithdraw, dayOfWithdrawl));
		return this.getBalance();
	}

	// method to deposit
	public double deposit(double amountToDeposit) {
		// this.balance += amountToDeposit;
		if (amountToDeposit < 0)
			throw new InvalidDataException();
		// add the deposit to the deposit class
		GregorianCalendar dayDepositMade = new GregorianCalendar();
		this.depositList.add(new Deposit(amountToDeposit, dayDepositMade));
		return this.getBalance();
	}

	public String printStatement(GregorianCalendar startdate,
			GregorianCalendar endDate) {
		StringBuffer buff = new StringBuffer();
		buff.append("Account Statement for Account # ");
		buff.append(this.id);
		buff.append(" As of ");
		SimpleDateFormat formated = new SimpleDateFormat("MM/dd/YYYY");
		buff.append(formated.format(endDate.getTime()));
		buff.append("\n Start Balance: ");
		buff.append(getBalanceAsOf(startdate));
		buff.append("\n Deposits: ");
		GregorianCalendar holder;
		// display each deposit that occurred from start date to end date =
		// after start date and beofore or at the time of the end date
		for (Deposit input : depositList) {
			holder = input.getDayOfDeposit();
			if (holder.after(startdate)
					&& (holder.before(endDate) || holder.equals(endDate))) {
				buff.append(input.getAmountDeposited());
				buff.append("\t");
			}
		}
		buff.append("\n Withdrawls: ");
		// display each withdrawl that occurred from start date to end date
		for (Withdrawl output : withdrawlList) {
			holder = output.getDayOfWithdrawl();
			if (holder.after(startdate)
					&& (holder.before(endDate) || holder.equals(endDate))) {
				buff.append(output.getAmountWithdrawl());
				buff.append("\t");
			}
		}
		buff.append("\n End balance: ");
		buff.append(getBalanceAsOf(endDate));
		return buff.toString();
	}

	public ArrayList<Deposit> allDepposits() {
		ArrayList<Deposit> list = new ArrayList<Deposit>();
		for (Deposit rewrite : this.depositList) {
			list.add(new Deposit(rewrite.getAmountDeposited(), rewrite
					.getDayOfDeposit()));
		}
		return list;
	}

	public ArrayList<Withdrawl> allWithdrawls() {
		ArrayList<Withdrawl> list = new ArrayList<Withdrawl>();
		for (Withdrawl rewrite : this.withdrawlList) {
			list.add(new Withdrawl(rewrite.getAmountWithdrawl(), rewrite
					.getDayOfWithdrawl()));
		}
		return list;
	}

	public Double getLargestDeposit() { // throws NullPointerException{
		Double biggest = -1.0;
		// if no deposits where made throw exception
		// if (this.depositList==null){
		// throw new NullPointerException() ;
		// }
		for (Deposit search : this.depositList) {
			if (search.getAmountDeposited() > biggest) {
				biggest = search.getAmountDeposited();
			}
		}
		if (biggest == -1) { // if no deposits where made the answer will be
								// null
			biggest = null;
		}
		return biggest;

	}

	public Double getLargestWithdrawl() {
		Double biggest = -1.0;
		for (Withdrawl search : this.withdrawlList) {
			if (search.getAmountWithdrawl() > biggest) {
				biggest = search.getAmountWithdrawl();
			}
		}
		if (biggest == -1) {
			biggest = null;
		}
		return biggest;

	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("For account with id: " + this.getId());
		buffer.append("\tThe balance is: $" + this.getBalance());
		buffer.append("\tThe monthly intrest is: $" + this.getMonthlyInterst());
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/YYYY");
		buffer.append("\tThe account was set up on day: "
				+ formatter.format(this.dateCreated.getTime()));
		return buffer.toString();
	}

	public int compareTo(Account other) throws NullPointerException {
		if (other == null) {
			throw new NullPointerException();
		}
		return this.dateCreated.compareTo(other.getDateCreated());
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Account other = (Account) obj;
		if (other.getBalance() != this.getBalance()) {
			return false;
		}

		return true;
	}

}
