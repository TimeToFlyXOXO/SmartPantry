package edu.ilstu;

public class Admin extends RegisteredUser {

	private int adminID;
	private static int adminCount = 1;
	
	
	
	public Admin(String name, String pass) {
		super(name, pass);
		adminID = adminCount;
		adminCount++;
	}
	
	

}
