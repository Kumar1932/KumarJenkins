package TestNG_Basics;

import org.testng.annotations.Test;

import com.Vtiger.BaseUtility.BaseClass;

public class CreateOrg extends BaseClass
{
@Test
public void createOrgWithNameTest()
{
	System.out.println("create org with name");
}

@Test
public void createOrgWithIndustryTest()
{
	System.out.println("create org with industry");
}
}
