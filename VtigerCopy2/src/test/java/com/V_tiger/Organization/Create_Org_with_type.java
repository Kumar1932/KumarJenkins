package com.V_tiger.Organization;

import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class Create_Org_with_type 
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
		
		String orgname = eu.getDataFromExcel("org",4 ,2 ) + jlib.getRandomNumber();
		String type = eu.getDataFromExcel("org",4 ,3 );
		String industry = eu.getDataFromExcel("org",4 ,4 );
		
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
		wlib.implicitWait(driver);
		wlib.maximize(driver);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		WebElement iDown = driver.findElement(By.name("industry"));
		WebElement tDown = driver.findElement(By.name("accounttype"));
        wlib.selectByVisibleText(iDown, industry);
		wlib.selectByVisibleText(tDown, type);
		
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
		String industryName = driver.findElement(By.id("dtlview_Industry")).getText();
		if(industryName.contains(industry))
		{
			System.out.println(industry+" is verified====>PASS");
		}
		else
		{
			System.out.println(industry+" is not verified====>FAIL");
		}
		String typeName = driver.findElement(By.id("mouseArea_Type")).getText();
		if(typeName.contains(type))
		{
			System.out.println(type+" is verified====>PASS");
		}
		else
		{
			System.out.println(type+" is not verified====>FAIL");
		}
		driver.quit();
	 }
}
