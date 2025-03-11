package TestNG_AssertBasics;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeSoftAssert 
{
	@Test
	public void CreateContactTest()
	{
		Reporter.log("test 1 start", true);
		Reporter.log("step 1",true);
		SoftAssert sAssert=new SoftAssert();
		sAssert.assertEquals("Title", "Title page");
		Reporter.log("step 2",true);
		Reporter.log("step 3",true);
		Reporter.log("step 4",true);
		Reporter.log("test 1 end",true);
		sAssert.assertAll();
	}

	@Test
	public void CreateContactWithDateTest()
	{
		Reporter.log("test 2 start", true);
		Reporter.log("step 1",true);
		Assert.assertEquals("Title", "Title");
		Reporter.log("step 2",true);
		Reporter.log("step 3",true);
		Reporter.log("step 4",true);
		Reporter.log("test 2 end",true);
	}
}
