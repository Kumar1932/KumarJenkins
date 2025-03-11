package MiscellaneousConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Make_My_Trip 
{
public static void main(String[] args) 
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.findElement(By.className("commonModal__close")).click();
	driver.findElement(By.xpath("//label[@for='departure']")).click();
	driver.findElement(By.xpath("//div[@aria-label='Sun Mar 16 2025']")).click();
	
    driver.close();
}
}
