package edu.ilstu;
public class Ingredient 
{

	private static int ingredientIDCount = 1;
	private int ingredientID;
	private String name;
	private double price;
	private int quantity;
	private boolean includeInSearch;
	
	public Ingredient(String name, int quantity, double price)
	{
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		ingredientID = ingredientIDCount;
		ingredientIDCount++;
	}
	

	public void changeQuantity(int amount)
	{
		quantity = amount;
	}
	
	public boolean equals(Ingredient ingredient)
	{
		if((ingredientID == ingredient.getId() && (quantity == ingredient.getQuantity())))
		{
			return true;	
		}
		else
		{
			return false;
		}
	}
	
	public int getId()
	{
		return ingredientID;
	}
	
	public int getQuantity()
	{
		return quantity;
		
	}
	
	public String getName()
	{
		return name;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public void setIncludeInSearch(boolean includeInSearch) {
		this.includeInSearch = includeInSearch;
	}
	
	
}