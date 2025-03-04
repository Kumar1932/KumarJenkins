package TestNG_Basics;

import org.testng.annotations.Test;

public class PracticePriority 
{
	@Test(priority=-1)
	public void createOrg()
	{
		System.out.println("Organization is created");
	}
	@Test(priority=2)
	public void createContact()
	{
		System.out.println("Contact is created");
	}
	
	@Test(priority=0) 
	public void createContactwithorg()
	{
		System.out.println("Contact is created with org");
	}
}
