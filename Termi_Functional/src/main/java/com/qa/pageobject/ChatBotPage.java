package com.qa.pageobject;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.qa.util.SeleniumLib;

public class ChatBotPage 
{
	SeleniumLib sLib;
	@FindBy(how=How.XPATH,using="//input[@placeholder='Type your message...']") WebElement msgBx;
	@FindBy(how=How.XPATH, using="//label[@class='wc-send']") WebElement sendBtn;
	@FindBy(how=How.XPATH, using="//div[@class='wc-list']") List<WebElement> lists;
	@FindBy(how=How.ID,using="divGlyphiconSettings") WebElement settingBtn;
	@FindBy(how=How.XPATH,using="//button[text()='Reports']") WebElement reportBtn;
	@FindBy(how=How.XPATH,using="(//div[@id='divSearchReportHubResults']/div)[1]") WebElement apReport;
	@FindBy(how=How.XPATH,using="//label[@title='Payee Report']/../following-sibling::div//button[text()='Run']") WebElement payeeReportRunBtn;
	@FindBy(how=How.XPATH,using="//select[@title='Select an option']") WebElement payeeSelectionDrpDwn;
	@FindBy(how=How.XPATH,using="//div[@id='mainDiv']//button[text()='Run']") WebElement reportRunBtn;
	
	
	public ChatBotPage(WebDriver driver)
	{
		sLib = new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public int sendUsrMsg(String msg)
	{
		int len=sLib.getNewResponseNumber();
		sLib.enterData(msgBx, msg);
		sLib.clickElement(sendBtn);
		return len;
	}
	
	
	public String getLatestResponse( int newResponseLength)
	{
		String response = sLib.getLatestResponse(newResponseLength);
		return response;
	}
	
	public String getLatestResponseFOrDashboards( int newResponseLength)
	{
		String response = sLib.getLatestResponseFOrDashboards(newResponseLength);
		return response;
	}
	
	
	public void clickMsgTxtBtn(String btnTxt,String expectedText)
	{
		sLib.clickOnTxtBtnMsg(btnTxt);
		sLib.iSleep(2);
//		sLib.latestResponseValidation(expectedText);
	}
	
	
	public void clickOnSettingBtn()
	{
		sLib.clickElement(settingBtn);
	}
	
	
	public void verifyChatPage(String title)
	{
		sLib.validatePageTitle(title, "We are on Chat Page");
		sLib.eWaitForVisible(20, msgBx);
	}
	
	
	public int getTotalOpenInWebResponses() 
	{
		int totalNumberOfOpenInWeb = sLib.getTotalOpenInWebResponses();	
		return totalNumberOfOpenInWeb;
	}
	
	
	public void clickOnOpenInWeb(int newOpenInWeb, String pageTitle)
	{
		sLib.clickOnLatestOpenInWeb(newOpenInWeb, pageTitle);
	}
	
	
	public int getTotalOpenInPdfResponses() 
	{
		int totalNumberOfOpenInPdf = sLib.getTotalOpenInPdfResponses();	
		return totalNumberOfOpenInPdf;
	}
	
	
	public void clickOnOpenInPdf(int newOpenInPdf, String pageTitle)
	{
		sLib.clickOnLatestOpenInPdf(newOpenInPdf, pageTitle);
	}
	
	public int getTotalOpenLinkResponses() 
	{
		int totalNumberOfOpenInPdf = sLib.getTotalOpenLinkResponses();	
		return totalNumberOfOpenInPdf;
	}
	
	public void clickOnOpenLinkForDirection(int newOpenLink, String pageTitle)
	{
		sLib.clickOnLatestOpenLinkForDirection(newOpenLink, pageTitle);
	}
	
	public void clickOnOpenLinkForRestaurants(int newOpenLink, String pageTitle)
	{
		sLib.clickOnLatestOpenLinkForRestaurants(newOpenLink, pageTitle);
	}
	
	public void reportRun(String payee, String pageTitle)
	{
		sLib.clickElement(reportBtn);
		sLib.eWaitForElementToBeClickable(20, apReport);
		sLib.clickElement(apReport);
		sLib.eWaitForElementToBeClickable(20, payeeReportRunBtn);
		sLib.clickElement(payeeReportRunBtn);
		sLib.eWaitForElementToBeClickable(20, payeeSelectionDrpDwn);
		sLib.selectOptionByText(payeeSelectionDrpDwn, payee);
		sLib.eWaitForElementToBeClickable(20, reportRunBtn);
		sLib.clickElement(reportRunBtn);
		sLib.windowHandlingReport(pageTitle);
		sLib.eWaitForElementToBeClickable(20, apReport);
		sLib.enterThroughKeys(Keys.ESCAPE);
	}
	
}
