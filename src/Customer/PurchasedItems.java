package customer;

/*
 *
 * equals do these two need all the peramters to teset if they are equal or can u comapre/test just the name?
 * compareTo
 *  
 * 
 */

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class PurchasedItems {
	private String itemName;
	private Integer amountPurchased;
	private Double cost;
	private String itemType;
	private GregorianCalendar dayBought;

	public PurchasedItems(String name, Integer amount, String type, Double price) throws InvalidDataException {
		if (amount < 0 || price < 0) {// if data is invalid throw error
			throw new InvalidDataException();
		}// if the data us valid the code will continue and assign values
		this.itemName = name;
		this.amountPurchased = amount;
		this.cost = price;
		this.itemType = type;
		this.dayBought = new GregorianCalendar(); // set the date bought to
													// current day
	}

	public Integer getAmountPurchased() {
		return amountPurchased;
	}

	public Double getCost() {
		return cost;
	}

	public String getItemName() {
		return this.itemName;
	}

	public GregorianCalendar getDayBought() {
		return dayBought;
	}

	public Double costForMultipleItems() {
		Double cost = this.amountPurchased * this.cost;
		return cost;
	}

	public String getItemType() {
		return itemType;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(this.itemName + ":");
		buffer.append("type: ");
		buffer.append(this.itemType);
		buffer.append("    cost: $" + this.cost);
		buffer.append("    amount purchased: " + this.amountPurchased);
		buffer.append("    date purchase: ");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		buffer.append(formatter.format(this.dayBought.getTime()));
		return buffer.toString();

	}

	/*
	 * see if they are they have the same name
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchasedItems other = (PurchasedItems) obj;
		/*
		 * if (amountPurchased == null) { if (other.amountPurchased != null)
		 * return false; } else if
		 * (!amountPurchased.equals(other.amountPurchased)) return false; if
		 * (cost == null) { if (other.cost != null) return false; } else if
		 * (!cost.equals(other.cost)) return false; if (dayBought == null) { if
		 * (other.dayBought != null) return false; } else if
		 * (!dayBought.equals(other.dayBought)) return false;
		 */
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (itemName.equals(other.itemName))
			return true;
		/*
		 * if (itemType == null) { if (other.itemType != null) return false; }
		 * else if (!itemType.equals(other.itemType)) return false; return true;
		 */
		return false;
	}

	/*
	 * compare item names
	 */
	public int compareTo(PurchasedItems other) {
		return this.itemName.compareToIgnoreCase(other.itemName);
	}

}
