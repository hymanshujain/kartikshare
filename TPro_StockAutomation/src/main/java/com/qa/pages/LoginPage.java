package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.pageHelper.Home_PageHelper;
import com.qa.utils.TestBase;

public class LoginPage extends TestBase{

	// Page Factory - OR:
	@FindBy(xpath="//input[@id = 'logintxtUserName']")
	WebElement username;

	@FindBy(xpath="//input[@id = 'logintxtPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@class='loginSubmitBtn']")
	WebElement loginBtn;

//	@FindBy(xpath = "//[@class='loginheaderlogo']")
//	WebElement TproLogo;
	
	//Initializing the page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pw) throws InterruptedException {
		Thread.sleep(2000);
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		
		return new HomePage(null);//Home_PageHelper(null);
	}
	

}
