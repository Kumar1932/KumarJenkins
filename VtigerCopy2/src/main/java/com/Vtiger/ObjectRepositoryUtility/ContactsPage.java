package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

/**
 * All the elements of ContactsPage are present in this class
 * @author kumar
 */

public class ContactsPage 
{
	WebDriverUtility wlib=new WebDriverUtility();
    WebDriver driver;
	public ContactsPage(WebDriver driver) 
	{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement addContactBtn;
	
	public WebElement getAddContactBtn() {
		return addContactBtn;
	}
	
	
}
