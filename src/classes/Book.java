package classes;

public class Book {
	private String title;
	private Double cost;
	
	public Book(String title, Double cost)
	{
		this.title = title;
		this.cost = cost;
	}
	
	public String toString()
	{
		return "Book " + title + " Cost " + cost;
	}

}
