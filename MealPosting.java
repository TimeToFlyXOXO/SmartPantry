package edu.ilstu;

import java.util.ArrayList;
import java.util.Calendar;


public class MealPosting {
	
	private int mealPostingIDCount;
	private int mealPostingID;
	private Recipe postingRecipe;
	private String name;
	private int rsvpNumber;
	private ArrayList<RegisteredUser> rsvpList = new ArrayList<RegisteredUser>();
	private boolean isVegetarian;
	
	public int getMealPostingID() {
		return mealPostingID;
	}

	public Recipe getPostingRecipe() {
		return postingRecipe;
	}

	public String getName() {
		return name;
	}

	private Calendar time;
	
	public Calendar getTime() {
		return time;
	}

	public MealPosting(Recipe postingRecipe, String name)
	{
		this.postingRecipe = postingRecipe;
		this.name = name;
		time = Calendar.getInstance();
		this.isVegetarian = postingRecipe.isVegetarian();
		mealPostingID = mealPostingIDCount;
		mealPostingIDCount++;	
	}
	
	public void addRsvpUser(RegisteredUser rsvpUser)
	{
		if(rsvpList.size() < rsvpNumber)
		{
			rsvpList.add(rsvpUser);
		}
	}
	
	public void removeRsvpUser(RegisteredUser rsvpUser)
	{
		for(int userCount = 0; userCount < rsvpList.size(); userCount++)
		{
			if(rsvpList.get(userCount).getUserID() == (rsvpUser.getUserID()))
			{
				this.rsvpList.remove(userCount);
			}
		}
	}

}
