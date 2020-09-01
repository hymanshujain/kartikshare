package com.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.SeleniumLib;




public class BasePage
{
	SeleniumLib sLib;
	
	@FindBy(how=How.XPATH,using="//a[@class='dropdown-toggle']") WebElement user;
	@FindBy(how=How.XPATH,using="//a[@class='dropdown-toggle']/..//label[text()='Sign out']") WebElement signOutBtn;
	
	public BasePage(WebDriver driver)
	{
		sLib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void logout()
	{
		sLib.clickElement(user);
		sLib.clickElement(signOutBtn);
	}
	
}
