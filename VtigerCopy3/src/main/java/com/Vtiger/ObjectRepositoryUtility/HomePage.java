package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

/**
 * All the elements of HomePage are present in this class
 * @author kumar
 */

public class HomePage 
{
	WebDriverUtility wlib=new WebDriverUtility();
   
	public HomePage(WebDriver driver) 
	{
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;    
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(xpath="//td[@class='genHeaderSmall']/following-sibling::td/img[@src='themes/softed/images/user.PNG']")
    private WebElement profileIcon;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutLink;

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void setSignOutLink(WebElement signOutLink) {
		this.signOutLink = signOutLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	
	public WebElement getProfileIcon() {
		return profileIcon;
	}

	
	
//	public void navigateToCampaignPage()
//	{
//		//wrong
//		campaignsLink.click();
//	}
	
	
	

}
