package TestNG_Basics;

import org.testng.annotations.Test;

public class PracticeDependsOnMethod 
{
	@Test(priority=1)
	public void createContact()
	{
		System.out.println("Contact is created");
	}
	
	@Test(dependsOnMethods="createOrg")
	public void createContactwithorg()
	{
		System.out.println("Contact is created with org");
	}
	@Test(priority=2)
	public void createOrg()
	{
		System.out.println("Organization is created");
	}
}
