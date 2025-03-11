package com.V_tiger.Contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Vtiger.BaseUtility.BaseClass;
import com.Vtiger.ObjectRepositoryUtility.ContactInfoPage;
import com.Vtiger.ObjectRepositoryUtility.ContactsPage;
import com.Vtiger.ObjectRepositoryUtility.CreateNewContactPage;
import com.Vtiger.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationInfoPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationsWindowPopUp;
import com.Vtiger.generic.WebDriverUtility.UtilityClassObject;
import com.aventstack.extentreports.Status;
//@Listeners(com.Vtiger.generic.ListenerUtility.ListenerImplimentation.class)
public class CreateContactTest extends BaseClass
{
 @Test(groups="smokeTest")
 public void createContactWithNameTest() throws Exception
 {
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String lastName = elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	UtilityClassObject.getTest().log(Status.INFO, "navigated to home page");
	ContactsPage cp=new ContactsPage(driver);
	cp.getAddContactBtn().click();
	UtilityClassObject.getTest().log(Status.INFO, "navigated to contact page");
	
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastNameEdit().sendKeys(lastName);
	cncp.getSaveContactBtn().click();
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String header = cip.getHeaderTextVerify().getText();
	boolean status = header.contains(lastName);
	Assert.assertEquals(status, true);
	
	String actLastName = cip.getLastNameVerify().getText().trim();
	SoftAssert sAssert=new SoftAssert();
	sAssert.assertEquals(actLastName, lastName);
	
	sAssert.assertAll();

 }
 @Test(groups="regressionTest")
 public void createContactWithDateTest() throws Exception
 {
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String lastName = elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
	String startDate = jlib.getSystemDateYYYYMMDD();
	String endDate = jlib.getRequiredDateYYYYMMDD(30);
	HomePage hp=new HomePage(driver);
	hp.getContactsLink().click();
	UtilityClassObject.getTest().log(Status.INFO, "navigated to home page");
	
	ContactsPage cp=new ContactsPage(driver);
	UtilityClassObject.getTest().log(Status.INFO, "navigated to contact page");
	cp.getAddContactBtn().click();
	
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastNameEdit().sendKeys(lastName);
	WebElement ele = cncp.getStartDateEdit();
	ele.clear();
	ele.sendKeys(startDate);
	WebElement ele1 = cncp.getEndDateEdit();
	ele1.clear();
	ele1.sendKeys(endDate);
	cncp.getSaveContactBtn().click();
	
	ContactInfoPage cip=new ContactInfoPage(driver);
	String header = cip.getHeaderTextVerify().getText();
	boolean status = header.contains(lastName);
	Assert.assertEquals(status, true);
	
	String actLastName = cip.getLastNameVerify().getText().trim();
	SoftAssert sAssert=new SoftAssert();
	sAssert.assertEquals(actLastName, lastName);

	sAssert.assertAll();
 }
 
 @Test(groups="regressionTest")
 public void createContactWithOrgTest() throws Exception
 {
	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
	String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
	String lastName = elib.getDataFromExcel("contact", 1, 2)+ jlib.getRandomNumber();
	String startDate = jlib.getSystemDateYYYYMMDD();
	String endDate = jlib.getRequiredDateYYYYMMDD(30);
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	UtilityClassObject.getTest().log(Status.INFO, "navigated to home page");
	
	OrganizationPage op=new OrganizationPage(driver);
	UtilityClassObject.getTest().log(Status.INFO, "navigated to contact page");
	op.getAddOrgBtn().click();
	
	CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
	cnp.getOrgNameEdit().sendKeys(orgName);
	
	cnp.getSaveBtn().click();
	
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String header = oip.getHeaderElementVerify().getText();
	boolean orgStatus = header.contains(orgName);
	Assert.assertEquals(orgStatus, true);
	
	hp.getContactsLink().click();
	ContactsPage cp=new ContactsPage(driver);
	cp.getAddContactBtn().click();
	
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
	cncp.getLastNameEdit().sendKeys(lastName);
	WebElement ele = cncp.getStartDateEdit();
	ele.clear();
	ele.sendKeys(startDate);
	WebElement ele1 = cncp.getEndDateEdit();
	ele1.clear();
	ele1.sendKeys(endDate);
	cncp.getAttachOrgBtn().click();
	
	wlib.switchToWindowByURL(driver, "module=Accounts&action=Popup");
	OrganizationsWindowPopUp owp=new OrganizationsWindowPopUp(driver);
	owp.getSearchEdit().sendKeys(orgName);
	owp.getSearchBtn().click();
	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	wlib.switchToWindowByURL(driver, "module=Contacts&action=EditView");
	
	cncp.getSaveContactBtn().click();

	ContactInfoPage ip=new ContactInfoPage(driver);
	String cHeader = ip.getHeaderTextVerify().getText();
	boolean status = cHeader.contains(lastName);
	Assert.assertEquals(status, true);
	
	String actLastName = ip.getLastNameVerify().getText().trim();
	SoftAssert sAssert=new SoftAssert();
	sAssert.assertEquals(actLastName, lastName);
	
	String actOrgName = ip.getOrgNameVerify().getText().trim();
	sAssert.assertEquals(actOrgName, orgName);
	
	sAssert.assertAll();
 }
}
