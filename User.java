package edu.ilstu;
import java.util.ArrayList;

public class User 
{
	
	private Pantry userPantry;
	private MyRecipes recipes;
	private Settings mySettings;
	
	private ArrayList<Recipe> selectSearchMyRecipes(ArrayList<Ingredient> ingredientsOwned)
	{
		return recipes.getPossibleRecipes(userPantry.getIngredients());
	}
	
	public User()
	{
		userPantry = new Pantry();
		recipes = new MyRecipes();
		mySettings = new Settings();
	}
	
}
