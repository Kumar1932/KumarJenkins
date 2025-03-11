package MiscellaneousConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ThreadPoolSize 
{
@Test(invocationCount = 3,threadPoolSize = 3)
public void run()
{
	WebDriver driver=new ChromeDriver();
	driver.get("http://49.249.28.218:8889/dolibarr/");
}
}
