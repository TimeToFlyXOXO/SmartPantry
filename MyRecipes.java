package edu.ilstu;
import java.util.ArrayList;

public class MyRecipes {

	private ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
	private ArrayList<Recipe> favoriteRecipes = new ArrayList<Recipe>();
	
	public MyRecipes()
	{
		recipeList = new ArrayList<Recipe>();
	}
	
	public Recipe getRecipe(int recipeID)
	{
		for(int userCount = 0; userCount < recipeList.size(); userCount++)
		{
			if(recipeList.get(userCount).getRecipeID() == recipeID)
			{
				return recipeList.get(userCount);
			}
		}
		return null;//Returns nothing if there are no matches
	}
	
	
	public void addRecipe(Recipe recipe)
	{
		int recipeBuffer = recipe.getRecipeID();
		
		if(getRecipe(recipeBuffer) == null)
		{
			recipeList.add(recipe);
		}
	}
	
	public void editRecipe(int recipeId, String name, ArrayList<Ingredient> ingredientList)
	{
		Recipe recipe = recipeList.get(recipeId);
		if(recipe.getName().equals(name) && recipe.getRecipeIngredients().equals(ingredientList) )
		{
			
		}
		
		else
		{
			recipe.setName(name);
			recipe.setRecipeIngredients(ingredientList);
			int count = Recipe.getRecipeIDCount();
			recipe.setRecipeID(count);
			recipe.setRecipeIDCount(count+1);
		}
	}
	
	
	public void removeRecipe(Recipe recipe)
	{
		
		for(int userCount = 0; userCount < recipeList.size(); userCount++)
		{
			if(recipeList.get(userCount).getRecipeID()== recipe.getRecipeID())
			{
				recipeList.remove(userCount);
			}
		}	
	}
	
	
	private void editRecipe(Recipe recipe)
	{
		
	}

	
	private void addFavorite(Recipe recipe)
	{
		favoriteRecipes.add(recipe);
	}
	
	
	
	public ArrayList<Recipe> getPossibleRecipes(ArrayList<Ingredient> ingredientList)
	{
		ArrayList<Recipe> recipesPossible = new ArrayList<Recipe>();
		for(int recipeCount = 0; recipeCount < recipeList.size(); recipeCount++) //Cycles through all recipes in recipeList
		{
			boolean isPossible = true;
			for(int ingredientCount = 0; ingredientCount < ingredientList.size(); ingredientCount++) //Cycles through all ingredients in ingredientList
			{
				if(!(recipeList.get(recipeCount).contains(ingredientList.get(ingredientCount))))
				{
					isPossible = false;
					ingredientCount = ingredientList.size() + 2;//Prevents recipe from checking for any further ingredient matches and moves onto next recipe
				}
			}
			if(isPossible)
			{
				recipesPossible.add(recipeList.get(recipeCount));
			}
		}
		return recipesPossible;
	}
	
}