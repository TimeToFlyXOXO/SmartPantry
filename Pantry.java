package edu.ilstu;
import java.util.ArrayList;

public class Pantry 
{
	
	private ArrayList<Ingredient> userIngredients;
	
	public Pantry()
	{
		userIngredients = new ArrayList<Ingredient>();
	}
	
	private void addIngredient(Ingredient ingredient)
	{
		userIngredients.add(ingredient);
	}
	
	private void removeIngredient(Ingredient ingredient)
	{
		int ingredientID = ingredient.getId();
		
		for(int ingredientCount = 0; ingredientCount < userIngredients.size(); ingredientCount++)
		{
			if(userIngredients.get(ingredientCount).getId() == ingredientID)
			{
				userIngredients.remove(ingredientCount);
			}
		}
	}
	
	private void editIngredient(Ingredient ingredient, int newQuantity)
	{
		ingredient.setQuantity(newQuantity);//Only edits quantity need to check how team wants to do this
	}
	
	public ArrayList<Ingredient> getIngredients()
	{
		return userIngredients;
	}
	
	public boolean contains(Ingredient ingredient)
	{
		for(int ingredientCount = 0; ingredientCount < userIngredients.size(); ingredientCount++)
		{
			if(userIngredients.get(ingredientCount).equals(ingredient))
			{
				return true;
			}
		}
		return false; //Returns false if ingredient does not match any ingredients in pantry
	}

}