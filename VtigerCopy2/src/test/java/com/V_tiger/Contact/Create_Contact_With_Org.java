package com.V_tiger.Contact;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class Create_Contact_With_Org 
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

	   String orgname = eu.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
	   String lastName = eu.getDataFromExcel("contact", 1, 2);
		 
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
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgname))
		{
			System.out.println(orgname+" is created====>PASS");
		}
		else
		{
			System.out.println(orgname+" is not created====>FAIL");
		}
		String actOrg = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if(actOrg.trim().equals(orgname))
		{
			System.out.println(orgname+" is created====>PASS");
		}
		else
		{
			System.out.println(orgname+" is not created====>FAIL");
		}
		
		
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
	    wlib.switchToWindowByURL(driver, "module=Accounts&action");
	    
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		wlib.switchToWindowByURL(driver, "module=Contacts&action");
		
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
		String actOrg2 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrg2.trim().equals(orgname))
		{
			System.out.println(orgname+" is verified====>PASS");
		}
		else
		{
			System.out.println(orgname+" is not verified====>FAIL");
		}
		driver.quit();
	 }
}
