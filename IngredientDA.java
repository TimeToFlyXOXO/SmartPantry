package edu.ilstu;
import java.util.ArrayList;

public class IngredientDA
{
	private static ArrayList<Ingredient> ingredientList;
	
	
	public IngredientDA()
	{
		ingredientList = new ArrayList<Ingredient>();
	}
	
	public static Ingredient getIngredient(int ingredientID)
	{
		for(int userCount = 0; userCount < ingredientList.size(); userCount++)
		{
			if(ingredientList.get(userCount).getId() == ingredientID)
			{
				return ingredientList.get(userCount);
			}
		}
		return null;//Returns nothing if there are no matches
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		int ingredientBuffer = ingredient.getId();
		
		if(getIngredient(ingredientBuffer) == null)
		{
			ingredient.setQuantity(1);
			ingredientList.add(ingredient);
		}
	}
	
	public void editIngredient(int ingredientId, String name)
	{
		Ingredient ingredient = ingredientList.get(ingredientId);
		if(ingredient.getName().equals(name))
		{
			
		}
		
		else
		{
			ingredient.setName(name);
		}
	}
	
	
	public void removeIngredient(Ingredient ingredient)
	{
		
		for(int userCount = 0; userCount < ingredientList.size(); userCount++)
		{
			if(ingredientList.get(userCount).getId()== ingredient.getId())
			{
				ingredientList.remove(userCount);
			}
		}	
	}
	
	public static ArrayList<Ingredient> getUserList() {
		return ingredientList;
	}
}
