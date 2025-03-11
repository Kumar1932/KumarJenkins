package com.NinzaHRM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.Vtiger.generic.WebDriverUtility.WebDriverUtility;

public class RightclickKannada 
{
	public static void main(String[] args) throws InterruptedException, AWTException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in/");
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.implicitWait(driver);
		WebElement rClick = driver.findElement(By.xpath("//a[text()='ಕನ್ನಡ']"));
	    wlib.rightClickAndOpenInNewTab(driver, rClick);
		Thread.sleep(2000);
		driver.quit();
	}
}
