package com.V_tiger.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.LoginPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationInfoPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationPage;
import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class POM_Create_Org_With_Phone 
{
	public static void main(String[] args) throws Exception 
	{
	WebDriverUtility wlib=new WebDriverUtility();
	JavaUtility jlib=new JavaUtility();
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();

	String BROWSER = flib.getDataFromPropertiesFile("browser");
	String URL = flib.getDataFromPropertiesFile("url");
	String USERNAME = flib.getDataFromPropertiesFile("username");
	String PASSWORD = flib.getDataFromPropertiesFile("password");

	String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
	String type = elib.getDataFromExcel("org", 4, 3);
	String industry = elib.getDataFromExcel("org", 4, 4);
	String phone = elib.getDataFromExcel("org", 7, 5);
	
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
	else
	{
	driver=new ChromeDriver();	
	}

	driver.get(URL);
	wlib.implicitWait(driver);
	wlib.maximize(driver);
	LoginPage lp=new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);

	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();

	OrganizationPage op=new OrganizationPage(driver);
	op.getAddOrgBtn().click();

	CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
	cp.getOrgNameEdit().sendKeys(orgName);
	cp.getTypeDD().sendKeys(type);
	cp.getIndustryDD().sendKeys(industry);
	cp.getPhoneEdit().sendKeys(phone);
	
	cp.getSaveBtn().click();

	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String header = oip.getHeaderElementVerify().getText();
	if(header.contains(orgName))
	{
		System.out.println(orgName+" organization is created====>PASS");
	}
	else
	{
		System.out.println(orgName+" organization is not created");
	}
	
	String actOrg = oip.getOrgNameVerify().getText();
	if(orgName.equals(actOrg))
	{
		System.out.println(orgName +" is verified====>PASS");
	}
	else
	{
		System.out.println(orgName +" is not verified====>FAIL");
	}
	
	String actType = oip.getTypeDDVerify().getText();
	if(actType.equals(type))
	{
		System.out.println(type +" is verified====>PASS");
	}
	else
	{
		System.out.println(type +" is not verified====>FAIL");
	}
	
	String actIndustry = oip.getIndustryDDVerify().getText();
	if(actIndustry.equals(industry))
	{
		System.out.println(industry +" is verified====>PASS");
	}
	else
	{
		System.out.println(industry +" is not verified====>FAIL");
	}
	
	String actPhone = oip.getPhoneVerify().getText();
	if(actPhone.trim().equals(phone))
	{
		System.out.println(phone +" is verified====>PASS");
	}
	else
	{
		System.out.println(phone +" is not verified====>FAIL");
	}
	driver.quit();
	}
}
