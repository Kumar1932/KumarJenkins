package com.V_tiger.Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.ObjectRepositoryUtility.ContactInfoPage;
import com.Vtiger.ObjectRepositoryUtility.ContactsPage;
import com.Vtiger.ObjectRepositoryUtility.CreateNewContactPage;
import com.Vtiger.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.LoginPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationInfoPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationsWindowPopUp;
import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class POM_Create_Contact_With_Date 
{
	public static void main(String[] args) throws Exception 
	{
	FileUtility flib=new FileUtility();
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();

	String BROWSER = flib.getDataFromPropertiesFile("browser");
	String URL = flib.getDataFromPropertiesFile("url");
	String USERNAME = flib.getDataFromPropertiesFile("username");
	String PASSWORD = flib.getDataFromPropertiesFile("password");

	String lastName=elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
	String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
	String startDate = jlib.getSystemDateYYYYMMDD();
	String endDate = jlib.getRequiredDateYYYYMMDD(30);
	WebDriver driver=null;
	if(BROWSER.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox"))
	{
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("edge"))
	{
		driver=new ChromeDriver();
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

	CreateNewOrganizationPage cop=new CreateNewOrganizationPage(driver);
	cop.getOrgNameEdit().sendKeys(orgName);

	cop.getSaveBtn().click();

	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String header = oip.headerText();
	if(header.contains(orgName))
	{
		System.out.println(orgName+" organization is created====>PASS");
	}
	else
	{
		System.out.println(orgName+" organization is not created");
	}
	
	hp.getContactsLink().click();

	ContactsPage cp=new ContactsPage(driver);
	cp.getAddContactBtn().click();

	CreateNewContactPage cnp=new CreateNewContactPage(driver);
	cnp.getLastNameEdit().sendKeys(lastName);
	cnp.getAttachOrgBtn().click();
	
	wlib.switchToWindowByURL(driver, "module=Accounts&action=Popup");
	OrganizationsWindowPopUp owp=new OrganizationsWindowPopUp(driver);
	owp.getSearchEdit().sendKeys(orgName);
	owp.getSearchBtn().click();
	
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	
	wlib.switchToWindowByURL(driver, "module=Contacts&action=EditView");
	
	WebElement Startele = cnp.getStartDateEdit();
	WebElement Endele = cnp.getEndDateEdit();
	Startele.clear();
	Startele.sendKeys(startDate);
	Endele.clear();
	Endele.sendKeys(endDate);
	cnp.getSaveContactBtn().click();

	ContactInfoPage ip=new ContactInfoPage(driver);
	String cHeader = ip.getHeaderTextVerify().getText();
	if(cHeader.contains(lastName))
	{
		System.out.println(lastName+" contact is created");
	}
	else
	{
		System.out.println(lastName+" contact is not created");
	}

	String actLastName = ip.getLastNameVerify().getText();
	if(actLastName.trim().equals(lastName))
	{
		System.out.println(lastName+" is verified");
	}
	else
	{
		System.out.println(lastName+" is not verified");
	}
	String actOrgName = ip.getOrgNameVerify().getText();
	if(actOrgName.trim().equals(orgName))
	{
		System.out.println(orgName+" is verified");
	}
	else
	{
		System.out.println(orgName+" is not verified");
	}
	
	String actStartDate = ip.getStartDateVerify().getText();
	if(actStartDate.trim().equals(startDate))
	{
		System.out.println(startDate+" is verified");
	}
	else
	{
		System.out.println(startDate+" is not verified");
	}
	
	String actEndDate = ip.getEndDateVerify().getText();
	if(actEndDate.trim().equals(endDate))
	{
		System.out.println(endDate+" is verified");
	}
	else
	{
		System.out.println(endDate+" is not verified");
	}

	driver.quit();
	
	}
}
