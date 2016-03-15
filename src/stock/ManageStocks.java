package stock;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageStocks {

	public static void main(String[] args) {
		ArrayList<Stock> ourStocks = new ArrayList<Stock>();
		Scanner keyboard=new Scanner(System.in);
        int choice=0;
        do{
        	choice = menu();
        	switch(choice){
        	case 1:   //add a stock to list
        		System.out.println("What symbol do you want to add?");
        		String symbol=keyboard.nextLine();
        		System.out.println("What name do you want to add?");
        		String name=keyboard.nextLine();
        		ourStocks.add(new Stock(symbol,name));
        		break;
        	case 2:  //remove a stock from list
        		System.out.println("what is the symbol you want to remove?");
        		String remove=keyboard.nextLine();
        		for(Stock search: ourStocks){
        			if(search.getSymbol().equalsIgnoreCase(remove)){
        				ourStocks.remove(search);
        				System.out.println("it was removed");
        				break;
        			}
        		}
        		break;
        	case 3://record a price change of a stock
        		System.out.println("what is the stock change?");
        		Double change =keyboard.nextDouble();
        		keyboard.nextLine();
        		System.out.println("for what stock, write the symbol");
        		String record=keyboard.nextLine();
        		for(Stock search: ourStocks){
        			if(search.getSymbol().equalsIgnoreCase(record)){
        				try {
							search.recordPriceChange(change);
							System.out.println("changed");
							break;
						} catch (InvalidDateException | InvalidPriceException e) {
							e.printStackTrace();
						}
        			}
        		}
        		
        		
        		break;
        	case 4:  //list historical prices of a stock
        		System.out.println("which stock");
        		String thisOne = keyboard.nextLine();
        		for(Stock search: ourStocks){
        			if(search.getSymbol().equalsIgnoreCase(thisOne)){
        			try {
						System.out.println(search.getHistoricalPrices());
					} catch (InvalidDateException e) {
						System.out.println("error");
					} catch (InvalidPriceException e) {
						System.out.println("error");

					}
        			break;
        			}
        		}
        		break;
        	case 5: //view highest price of a stock
        		Double highestPrice=null;
        		for(Stock search: ourStocks){
        			if(search.getHighestPrice()>highestPrice){
        				highestPrice=search.getHighestPrice();
        			}
        			
        		}System.out.println(highestPrice);
        		break;
        	case 6: //view lowest price of a stock
        		Double lowestPrice=null;
        		for(Stock search: ourStocks){
        			if(search.getHighestPrice()<lowestPrice){
        				lowestPrice=search.getHighestPrice();
        			}
        			
        		}System.out.println(lowestPrice);
        		break;
        	case 7: //view current price of a stock
        		
        		break;
        	}
        	
        	
        }while (choice != 0);

	}
	
	
	private static Stock findStock(String symbol){
		//return the Stock with a specific symbol
		return null;
	}
	
	public static int menu(){
		int choice;
		Scanner keyboard = new Scanner(System.in);
			do{
				System.out.println("\n1. Record new stock\n2. Remove a stock\n3. Add price change of a Stock\n4. Get Historical Prices of a Stock\n5.Get Highest Price of a Stock\n6. Get Lowest Price of Stock\n7. Get Current Price of Stock\n8. List all Stock data\n0. EXIT");
	
		    choice = keyboard.nextInt();
		   } while (choice > 8);
			return choice;
	}

}
