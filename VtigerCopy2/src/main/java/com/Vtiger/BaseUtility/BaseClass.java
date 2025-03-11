package com.Vtiger.BaseUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.LoginPage;
import com.Vtiger.generic.DatabaseUtility.DatabaseUtility;
import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.UtilityClassObject;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass 
{
	public WebDriver driver=null;
	public static WebDriver sDriver=null;
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public ExcelUtility elib=new ExcelUtility();
	public DatabaseUtility dlib=new DatabaseUtility();
	public FileUtility flib=new FileUtility();
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException
	{
		System.out.println("======Coonect to database======");
		dlib.getDbConnection();
	}
//	@Parameters("BROWSER")
//	@BeforeClass(alwaysRun = true)
//	public void configBC(String browser) throws Exception
//	{
//		
//		String BROWSER=browser;
////		ChromeOptions co=new ChromeOptions();
////		co.addArguments("--Incognito");
//		if(BROWSER.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//			//driver=new ChromeDriver(co);
//		}
//		else if(BROWSER.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(BROWSER.equals("edge"))
//		{
//			driver=new EdgeDriver();
//		}
//		else
//		{
//			driver=new ChromeDriver();
//		}
//	    sDriver=driver;
//	    UtilityClassObject.setDriver(driver);
//	    wlib.maximize(driver);
//		System.out.println("======launch the brwoser======");
//	}
	
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Exception
	{
		
		//String BROWSER = flib.getDataFromPropertiesFile("browser");
		String BROWSER=System.getProperty("browser",flib.getDataFromPropertiesFile("browser"));
//		ChromeOptions co=new ChromeOptions();
//		co.addArguments("--Incognito");
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			//driver=new ChromeDriver(co);
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
	    sDriver=driver;
	    UtilityClassObject.setDriver(driver);
	    wlib.maximize(driver);
	    System.out.println("======launch the brwoser======");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Exception
	{
		
//		String URL = flib.getDataFromPropertiesFile("url");
//		String USERNAME = flib.getDataFromPropertiesFile("username");
//		String PASSWORD = flib.getDataFromPropertiesFile("password");
		String URL =System.getProperty("url",flib.getDataFromPropertiesFile("url"));
		String USERNAME =System.getProperty("username",flib.getDataFromPropertiesFile("username"));
		String PASSWORD =System.getProperty("password",flib.getDataFromPropertiesFile("password"));
		
		driver.get(URL);
		wlib.implicitWait(driver);
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("======login======");
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		
		HomePage hp=new HomePage(driver);
		wlib.moveToElement(driver, hp.getProfileIcon());
		hp.getSignOutLink().click();
		System.out.println("======logout======");
	}
	
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		System.out.println("======close the browser======");
		driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS()
	{
		System.out.println("======disconnect from database======");
		dlib.closeDbConnection();
	}
}
