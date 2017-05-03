package edu.ilstu;

import java.util.ArrayList;

public class UserSearch {
	
	ArrayList<Recipe> publicRecipes = RecipeDA.getRecipeList();
	
	
	public ArrayList<Recipe> searchByName(String name)
	{
		ArrayList<Recipe> results = new ArrayList<Recipe>();
		
		for(int userCount = 0; userCount < publicRecipes.size(); userCount++)
		{
			if(publicRecipes.get(userCount).getMealType().equals(name))
			{
				results.add(publicRecipes.get(userCount));
			}
		}
		
		return results;
	}
	
	public ArrayList<Recipe> searchByTime(int time)
	{
		ArrayList<Recipe> results = new ArrayList<Recipe>();
		
		for(int userCount = 0; userCount < publicRecipes.size(); userCount++)
		{
			if(publicRecipes.get(userCount).getTime() == time)
			{
				results.add(publicRecipes.get(userCount));
			}
		}
		return results;
	}
	
	public ArrayList<Recipe> searchByMealType(String mealType)
	{
		ArrayList<Recipe> results = new ArrayList<Recipe>();
		
		for(int userCount = 0; userCount < publicRecipes.size(); userCount++)
		{
			if(publicRecipes.get(userCount).getMealType().equals(mealType))
			{
				results.add(publicRecipes.get(userCount));
			}
		}
		
		return results;
	}
	


}
