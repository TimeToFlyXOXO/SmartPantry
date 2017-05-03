package edu.ilstu;

import java.util.List;

public class RegisteredUser extends User
{

	private static int userIDCount = 1;
	public static int currentUser = 0;
	private int userID;
	private String username;
	private String password;
	private List<RegisteredUser> friendList;
	private List<MealPosting> myPostings;
	private List<MealPosting> socialPostings;
	

	
	
	

	public List<MealPosting> getSocialPostings() {
		return socialPostings;
	}

	public RegisteredUser(String name, String pass)
	{
		userID = userIDCount;
		userIDCount++;
		username = name;
		password = pass;
		
	
	}
	
	
	public String getUsername()
	{
		return username;
	}
	
	public int getUserID()
	{
		return userID;
	}
	
	public boolean login(String username, String password)
	{
		RegisteredUser tempUser = RegisteredUserDA.getUser(username);
		
		if(tempUser != null)
		{
			if(tempUser.checkPassword(password))
			{
				currentUser = tempUser.getUserID();
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	private boolean checkPassword(String password)
	{
		if(this.password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void addFriend(String userName)
	{
		RegisteredUser newFriend = RegisteredUserDA.getUser(userName);
		friendList.add(newFriend);
		
	}
	
	public void removeFriend(String userName)
	{
		List<RegisteredUser> friendList = this.friendList;
		for(int userCount = 0; userCount < friendList.size(); userCount++)
		{
			if(friendList.get(userCount).getUsername().equals(userName))
			{
				this.friendList.remove(userCount);
			}
		}
	}
	
	public void shareMealPosting(MealPosting mealPosting)
	{
		myPostings.add(mealPosting);
		
		for(int userCount = 0; userCount < friendList.size(); userCount++)
		{
		RegisteredUser activeFriend = friendList.get(userCount);
		activeFriend.getSocialPostings().add(mealPosting);
		}
	}
	
	public void editMealPosting(MealPosting mealPosting)
	{
		
		for(int userCount = 0; userCount < myPostings.size(); userCount++)
		{
		
		if(myPostings.get(userCount).getMealPostingID() == mealPosting.getMealPostingID());
		{
			mealPosting = myPostings.get(userCount);
			
		}
		
		}
	}

	public void removeMealPosting(MealPosting mealPosting)
	{
		for(int userCount = 0; userCount < myPostings.size(); userCount++)
		{
			if(myPostings.get(userCount).getMealPostingID()== mealPosting.getMealPostingID())
			{
			myPostings.remove(userCount);
			}
		}
		
		
		for(int userCount = 0; userCount < friendList.size(); userCount++)
		{
		RegisteredUser activeUser = friendList.get(userCount);
			for(int socialCount = 0; socialCount < activeUser.getSocialPostings().size(); socialCount++)
			{	
				if(socialPostings.get(socialCount).getMealPostingID()== mealPosting.getMealPostingID())
				{
					socialPostings.remove(socialCount);
				}
		}
		}
		
		}
	
	public void logout()
	{
		currentUser = 0;
	}


}