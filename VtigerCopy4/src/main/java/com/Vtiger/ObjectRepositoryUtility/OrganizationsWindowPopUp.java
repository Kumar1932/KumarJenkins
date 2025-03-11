package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * All the elements of OrganizationsWindowPopUp are present in this class
 * and this window comes in CreateNewContactPage when we want to attach organization
 * @author kumar
 */

public class OrganizationsWindowPopUp 
{
	
		public OrganizationsWindowPopUp(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="search_txt")
		private WebElement searchEdit;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		
		public WebElement getSearchEdit() {
			return searchEdit;
		}
		
		public WebElement getSearchBtn() {
			return searchBtn;
		}


}
