package com.V_tiger.Contact;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class Create_Contact_With_SupportDate 
{
	public static void main(String[] args) throws Exception 
	 {
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		String BROWSER = fu.getDataFromPropertiesFile("browser");
		String URL = fu.getDataFromPropertiesFile("url");
		String USERNAME = fu.getDataFromPropertiesFile("username");
		String PASSWORD = fu.getDataFromPropertiesFile("password");
		
	    String lastName = eu.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();
		
		
		String startDate = jlib.getSystemDateYYYYMMDD();
	    String endDate = jlib.getRequiredDateYYYYMMDD(30);
	   
	    
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		WebElement sdate = driver.findElement(By.name("support_start_date"));
		sdate.clear();
		sdate.sendKeys(startDate);
		WebElement edate = driver.findElement(By.name("support_end_date"));
		edate.clear(); 
		edate.sendKeys(endDate);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String header = driver.findElement(By.className("dvHeaderText")).getText();
		if(header.contains(lastName))
		{
			System.out.println(lastName+" contact is created=====>PASS");
		}
		else
		{
			System.out.println(lastName+" contact is not created=====>FAIL");
		}
		String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actLastName.trim().equals(lastName))
		{
			System.out.println(lastName+" contact information page is dispalyed=====>PASS");
		}
		else
		{
			System.out.println(lastName+" contact information page is not dispalyed=====>FAIL");
		}
		
		String actStartDate = driver.findElement(By.id("mouseArea_Support Start Date")).getText();
		if(actStartDate.trim().equals(startDate))
		{
			System.out.println(startDate+ " is mentioned correctly=====>PASS");
		}
		else
		{
			System.out.println(startDate+ " is not mentioned correctly=====>FAIL");
		}
		
		String actEndDate = driver.findElement(By.id("mouseArea_Support End Date")).getText();

		if(actEndDate.trim().equals(endDate))
		{
			System.out.println(endDate+ " is mentioned correctly=====>PASS");
		}
		else
		{
			System.out.println(endDate+ " is not mentioned correctly=====>FAIL");
		}
		driver.quit();
	 }
}