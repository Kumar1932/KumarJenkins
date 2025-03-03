package TestNG_Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonXpath 
{
public static void main(String[] args) throws InterruptedException 
{
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	WebElement ele = driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
	ele.sendKeys("iphone");
	ele.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	String xpath="//span[contains(text(),'iPhone 16 128 GB: 5G Mobile Phone with Camera')]/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
	String text = driver.findElement(By.xpath(xpath)).getText();
	System.out.println(text);
    driver.quit();
}
}
