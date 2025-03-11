package TestNG_Basics;

import org.testng.annotations.Test;

import com.Vtiger.BaseUtility.BaseClass;

public class CreateContact extends BaseClass
{
	@Test
	public void createContactWithNameTest()
	{
		System.out.println("create org with Last name");
	}

	@Test
	public void createContactWithDateTest()
	{
		System.out.println("create org with Date");
	}
}
