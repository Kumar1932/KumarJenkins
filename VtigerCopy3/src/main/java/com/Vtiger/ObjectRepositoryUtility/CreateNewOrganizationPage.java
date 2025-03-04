package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All the elements of CreateNewOrganizationPage are present in this class
 * @author kumar
 */

public class CreateNewOrganizationPage 
{
	public CreateNewOrganizationPage(WebDriver driver) 
	{
	 PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(id="phone")
	private WebElement phoneEdit;
	
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneEdit() {
		return phoneEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
    
}
