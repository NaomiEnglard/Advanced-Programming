package stocks;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Stock {
	private String symbol;
	private String company;
	private Double lastRecordedPrice;
	private GregorianCalendar dateRecordedChange;
	
	private ArrayList<PriceRecord> historicalPrices;

	
	
	public Stock(String symbol, String company){
		this.symbol = symbol;
		this.company = company;
		this.lastRecordedPrice = null;
		this.dateRecordedChange = null;
		
		//instantiate the ArrayList
		historicalPrices = new ArrayList<PriceRecord>();
	}
	
	public void recordPriceChange(Double newprice) throws InvalidDateException, InvalidPriceException{
		//assume price change is for current date
		GregorianCalendar today = new GregorianCalendar();
		//since priceRecord does not except gregorain calander turn it into a string
		  int year,month,day;
		  year=today.get(Calendar.YEAR);
		  month=today.get(Calendar.MONTH);
		  day=today.get(Calendar.DAY_OF_MONTH);
		  String date= year+"/"+month+"/"+day+"/";
		
		this.dateRecordedChange = today;
		//add a price record instance to the list of historical prices
		historicalPrices.add(new PriceRecord(date,newprice));
		//modify the lastRecordedPrice stored in this Stock instance
		this.lastRecordedPrice = newprice;
	}
	
    public void recordPriceChange(String date, Double newprice) throws InvalidDateException, InvalidPriceException{
    	//add a PriceRecord instance to the list of historical prices
    	historicalPrices.add(new PriceRecord(date, newprice));
    	//modify the lastRecordedPrice stored in this Stock instance
    	this.lastRecordedPrice= newprice;
    }
    
    public String getSymbol(){
    	return symbol;
    }
    
    public String getCompany(){
    	return company;
    }
    
    
    public Double getCurrentPrice(){
    	return lastRecordedPrice;
    }
    
    public ArrayList<PriceRecord> getHistoricalPrices() throws InvalidDateException, InvalidPriceException{
    	//return a deep copy
    	//create a array list to store the copy that is the same size as historical
    	ArrayList<PriceRecord> copyList= new ArrayList<PriceRecord>();
    	 //copy the arraylist into new array
    		for(PriceRecord a :historicalPrices){
    		copyList.add(new PriceRecord(a.getDateAsString(), a.getCurrentPrice() ));
    	}
    	
    	return copyList;
    }
    
    public Double getLowestPrice(){
    	return null;
    }
    
    public Double getHighestPrice(){
    	return null;
    }
    
    public Double getAveragePrice(){
    	return null;
    }
    
    public GregorianCalendar getStartDateHistoricalData(){
    	return null;
    }
    
    
}
