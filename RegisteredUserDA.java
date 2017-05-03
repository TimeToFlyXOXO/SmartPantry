package edu.ilstu;
import java.util.ArrayList;

public class RegisteredUserDA
{
	private static ArrayList<RegisteredUser> userList;
	
	
	public RegisteredUserDA()
	{
		userList = new ArrayList<RegisteredUser>();
	}
	
	public void createAccount(String username, String password)
	{
		if(getUser(username) == null)//Confirms the username is not taken
		{
			RegisteredUser newUser = new RegisteredUser(username, password);
			userList.add(newUser);
		}
	}
	
	
	public static RegisteredUser getUser(String username)
	{
		for(int userCount = 0; userCount < userList.size(); userCount++)
		{
			if(userList.get(userCount).getUsername().equals(username))
			{
				return userList.get(userCount);
			}
		}
		return null;//Returns nothing if there are no matches
	}
	
	public void removeUserAccount(String userName)
	{
		
		for(int userCount = 0; userCount < userList.size(); userCount++)
		{
			if(userList.get(userCount).getUsername().equals(userName))
			{
				userList.remove(userCount);
			}
		}	
	}
	
	public static ArrayList<RegisteredUser> getUserList() {
		return userList;
	}
}
