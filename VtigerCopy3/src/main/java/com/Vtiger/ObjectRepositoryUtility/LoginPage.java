package com.Vtiger.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

/**
 * All the elements of LoginPage are present in this class 
 * and also the business method to login to Vtiger application
 * @author kumar
 */

public class LoginPage 
{
	WebDriverUtility wlib=new WebDriverUtility();
   
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    @FindBy(name="user_name")
    private WebElement usernameEdit;
    
    @FindBy(name="user_password")
    private WebElement passwordEdit;
    
    @FindBy(id="submitButton")
    private WebElement loginBtn;
    
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String userName,String password)
	{
		usernameEdit.sendKeys(userName);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
	

}