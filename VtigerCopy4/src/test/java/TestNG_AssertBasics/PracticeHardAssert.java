package TestNG_AssertBasics;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeHardAssert 
{
@Test
public void CreateContactTest()
{
	Reporter.log("test 1 start", true);
	Reporter.log("step 1",true);
	Assert.assertEquals("Title", "Title page");
	Reporter.log("step 2",true);
	Reporter.log("step 3",true);
	Reporter.log("step 4",true);
	Reporter.log("test 1 end",true);
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
