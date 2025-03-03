package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All the elements of OrganizationInfoPage are present in this class
 * @author kumar
 */

public class OrganizationInfoPage 
{
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) 
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameVerify;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industryDDVerify;
	
	@FindBy(id="mouseArea_Type")
	private WebElement typeDDVerify;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phoneVerify;
	
	public WebElement getHeaderElementVerify() {
		return headerText;
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getIndustryDDVerify() {
		return industryDDVerify;
	}

	public WebElement getTypeDDVerify() {
		return typeDDVerify;
	}

	public WebElement getPhoneVerify() {
		return phoneVerify;
	}
	
	public String headerText()
	{
		String text = headerText.getText();
		return text;
	}
}
