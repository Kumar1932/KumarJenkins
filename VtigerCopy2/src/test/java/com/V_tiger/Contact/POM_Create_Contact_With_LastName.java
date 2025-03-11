package com.V_tiger.Contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Vtiger.ObjectRepositoryUtility.ContactInfoPage;
import com.Vtiger.ObjectRepositoryUtility.ContactsPage;
import com.Vtiger.ObjectRepositoryUtility.CreateNewContactPage;
import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.LoginPage;
import com.Vtiger.generic.FileUtility.ExcelUtility;
import com.Vtiger.generic.FileUtility.FileUtility;
import com.Vtiger.generic.WebDriverUtility.JavaUtility;
import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class POM_Create_Contact_With_LastName 
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
hp.getContactsLink().click();

ContactsPage cp=new ContactsPage(driver);
cp.getAddContactBtn().click();

CreateNewContactPage cnp=new CreateNewContactPage(driver);
cnp.getLastNameEdit().sendKeys(lastName);
cnp.getSaveContactBtn().click();

ContactInfoPage ip=new ContactInfoPage(driver);
String header = ip.getHeaderTextVerify().getText();
if(header.contains(lastName))
{
	System.out.println(lastName+" contact is created");
}
else
{
	System.out.println(lastName+" contact is not created");
}

String actLastName = ip.getLastNameVerify().getText();
if(actLastName.contains(lastName))
{
	System.out.println(lastName+" is verified");
}
else
{
	System.out.println(lastName+" is not verified");
}


driver.quit();
}
}
