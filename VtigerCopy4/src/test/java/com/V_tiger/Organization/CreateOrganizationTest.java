package com.V_tiger.Organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Vtiger.BaseUtility.BaseClass;
import com.Vtiger.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.Vtiger.ObjectRepositoryUtility.HomePage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationInfoPage;
import com.Vtiger.ObjectRepositoryUtility.OrganizationPage;
import com.Vtiger.generic.WebDriverUtility.UtilityClassObject;
import com.aventstack.extentreports.Status;
//@Listeners(com.Vtiger.generic.ListenerUtility.ListenerImplimentation.class)
public class CreateOrganizationTest extends BaseClass
{
	@Test(groups="smokeTest")
	public void createOrgWithNameTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigating to home page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigating to Org page");
		OrganizationPage op=new OrganizationPage(driver);
		op.getAddOrgBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "navigating to create new Org page");
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.getOrgNameEdit().sendKeys(orgName);
		
		cnp.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, orgName+"====>Creating New org");
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String header = oip.getHeaderElementVerify().getText();
	    boolean status = header.contains(orgName);
	    Assert.assertEquals(status, true);
	    
	    
	}
	
	@Test(groups="regressionTest")
	public void createOrgWithPhoneTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String orgName = elib.getDataFromExcel("org", 1, 2)+ jlib.getRandomNumber();
		String phone = elib.getDataFromExcel("org", 7, 5);
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to home page");
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getAddOrgBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "navigated to organization page");
		
		CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
		cnp.getOrgNameEdit().sendKeys(orgName);
		cnp.getPhoneEdit().sendKeys(phone);
		
		cnp.getSaveBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO, orgName+"org is created");
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String header = oip.getHeaderElementVerify().getText();
		boolean status = header.contains(orgName);
		Assert.assertEquals(status, true);
	    
		
		String actOrgName = oip.getOrgNameVerify().getText().trim();
        SoftAssert sAssert=new SoftAssert();
        sAssert.assertEquals(actOrgName, orgName);
        
		String actPhone = oip.getPhoneVerify().getText().trim();
		sAssert.assertEquals(actPhone, phone);
		
		sAssert.assertAll();
	
	}
	
    @Test(groups="regressionTest")
    public void createOrgWithTypeTest() throws Exception
    {
    	UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
    	String orgName = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomNumber();
    	String type = elib.getDataFromExcel("org", 4, 3);
    	String industry = elib.getDataFromExcel("org", 4, 4);
    	
    	HomePage hp=new HomePage(driver);
    	hp.getOrgLink().click();
    	UtilityClassObject.getTest().log(Status.INFO, "navigated to home page");
    	
    	OrganizationPage op=new OrganizationPage(driver);
    	UtilityClassObject.getTest().log(Status.INFO, "navigated to organization page");
    	op.getAddOrgBtn().click();

    	CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
    	cp.getOrgNameEdit().sendKeys(orgName);
    	cp.getTypeDD().sendKeys(type);
    	cp.getIndustryDD().sendKeys(industry);

    	cp.getSaveBtn().click();
    	
    	UtilityClassObject.getTest().log(Status.INFO, orgName+"org is created");
    	
    	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
    	String header = oip.getHeaderElementVerify().getText();
    	boolean status = header.contains(orgName);
    	Assert.assertEquals(status, true);
    	
    	String actOrg = oip.getOrgNameVerify().getText().trim();
    	
    	SoftAssert sAssert=new SoftAssert();
    	sAssert.assertEquals(actOrg, orgName);
    	
    	String actType = oip.getTypeDDVerify().getText().trim();
    	sAssert.assertEquals(actType, type);

    	String actIndustry = oip.getIndustryDDVerify().getText();
    	sAssert.assertEquals(actIndustry, industry);
    	
    	sAssert.assertAll();
    }
}
