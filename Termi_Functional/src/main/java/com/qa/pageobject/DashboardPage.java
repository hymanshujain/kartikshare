package com.qa.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.SeleniumLib;

public class DashboardPage extends BasePage
{

	SeleniumLib sLib;
	@FindBy(how=How.XPATH,using="//div[@id='divGlyphiconChatBot']") WebElement chatIcon;
	
	public DashboardPage(WebDriver driver) {
		super(driver);
		sLib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}

	public void clickOnChatIcon()
	{
		sLib.clickElement(chatIcon);
	}
	
}
