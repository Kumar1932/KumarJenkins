package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All the elements of OrganizationPage are present in this class
 * @author kumar
 */

public class OrganizationPage 
{
	public OrganizationPage(WebDriver driver) 
	{
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	WebElement addBtn;
	
	public WebElement getAddOrgBtn() 
	{
		return addBtn;
	}	
}
