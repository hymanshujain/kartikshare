package com.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.SeleniumLib;

public class LoginPage
{
	SeleniumLib sLib;
	@FindBy(how=How.ID,using="inputEmail") WebElement usrNmTxtBx;
	@FindBy(how=How.ID,using="inputPassword") WebElement pwdTxtBx;
	@FindBy(how=How.XPATH,using="//button[text()='Login']") WebElement loginBtn;
	
	public LoginPage(WebDriver driver)
	{
		sLib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password)
	{
		sLib.enterData(usrNmTxtBx, username);
		sLib.enterData(pwdTxtBx, password);
		
	}
	public void clickOnLoginBtn()
	{
		sLib.clickElement(loginBtn);
	}
	
	public void verifyLoginPage(String expectedText)
	{
		sLib.validatePageTitle(expectedText, "Page Title Verified");
		
	}
}
