package MiscellaneousConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Air_India 
{
public static void main(String[] args) throws InterruptedException
{
WebDriver driver=new ChromeDriver();
driver.get("https://www.airindia.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.findElement(By.xpath("//button[text()='Accept All']")).click();
driver.findElement(By.xpath("//input[@placeholder='Select Date']")).click();
driver.findElement(By.xpath("//div[@aria-label='Wednesday, March 12, 2025']")).click();
driver.findElement(By.xpath("//div[@aria-label='Friday, March 21, 2025']")).click();
driver.findElement(By.xpath("//button[text()=' Confirm ']")).click();

Thread.sleep(2000);
driver.quit();
}
}
