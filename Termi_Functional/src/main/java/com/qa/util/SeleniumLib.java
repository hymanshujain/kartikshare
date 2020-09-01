package com.qa.util;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
	WebDriver driver;

	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}

	//----------------------------------------------------------------------------
	//Enter Data into TextBox
	//----------------------------------------------------------------------------
	public void enterData(WebElement txtBx, String input) 
	{
		if(txtBx.getAttribute("value") != null)
		{
			txtBx.clear();
			txtBx.sendKeys(input);

		}
		else
		{
			txtBx.sendKeys(input);
		}
	}
	
	//----------------------------------------------------------------------------
	//sendKeys through keyBoard Buttons
	//----------------------------------------------------------------------------
	public void enterThroughKeys(Keys key) 
	{
		Actions act = new Actions(driver);
		act.sendKeys(key).perform();
	}

	//----------------------------------------------------------------------------
	//Click Element
	//----------------------------------------------------------------------------

	public void clickElement(WebElement element)
	{
		if(element.getTagName().equalsIgnoreCase("input") || element.getTagName().equalsIgnoreCase("button"))
		{
			if(element.getAttribute("type").equalsIgnoreCase("button"))
			{
				element.click();
			}
			else if(element.getAttribute("type").equalsIgnoreCase("submit"))
			{
				element.submit();
			}
			else if(element.getAttribute("type").equalsIgnoreCase("checkbox"))
			{

				if(element.isSelected())
				{

				}
				else
				{
					element.click();
				}
			}
			else if(element.getAttribute("type").contains("radio"))
			{
				element.click();
			}
		}

		else if(element.getTagName().equals("a"))
		{
			element.click();
		}
		else if(element.getTagName().equals("img"))
		{
			element.click();
		}
		else if(element.getTagName().equals("span"))
		{
			element.click();
		}
		else if(element.getTagName().equals("div"))
		{
			element.click();
		}
		else if(element.getTagName().equals("label"))
		{
			element.click();
		}
	}

	//----------------------------------------------------------------------------
	//Default Click On Element
	//----------------------------------------------------------------------------

	public void defaultClick(WebElement element)
	{
		element.click();
	}

	//----------------------------------------------------------------------------
	//Select Option By Text
	//----------------------------------------------------------------------------

	public void selectOptionByText(WebElement drpDwn,String optionText)
	{
		Select sel = new Select(drpDwn);
		sel.selectByVisibleText(optionText);
	}

	//----------------------------------------------------------------------------
	//Thread Sleep
	//----------------------------------------------------------------------------

	public void iSleep(int seconds)
	{
		try
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e) 
		{

			e.printStackTrace();
		}
	}


	//----------------------------------------------------------------------------
	//Explicit wait on element visibility
	//----------------------------------------------------------------------------
	public WebElement eWaitForVisible(int seconds,WebElement element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, seconds);
		WebElement wb = wait.until(ExpectedConditions.visibilityOf(element));
		return wb;
	}
	
	
	//----------------------------------------------------------------------------
	//Explicit wait on element is clickable
	//----------------------------------------------------------------------------
	public void eWaitForElementToBeClickable(int seconds,WebElement element)
	{
		WebDriverWait wait =  new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	//----------------------------------------------------------------------------
	//Explicit wait on element present
	//----------------------------------------------------------------------------

	public void eWaitForPresent(int seconds,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		try
		{
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
		
	}

	//----------------------------------------------------------------------------
	//Explicit wait on all element present
	//----------------------------------------------------------------------------

	public void eWaitForAllElementPresent(int seconds,By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	//----------------------------------------------------------------------------
	//Fluent Wait on Element using text
	//----------------------------------------------------------------------------
	public WebElement fluentWaitOnText(WebElement element, String Text)
	{
		FluentWait<WebDriver> fluent= new FluentWait<WebDriver>(driver);
		fluent.withTimeout(Duration.ofSeconds(20));
		fluent.pollingEvery(Duration.ofMillis(10));
		fluent.ignoring(NoSuchElementException.class);
		WebElement wb = fluent.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver)
			{
				if(element.getText().contains(Text))
				{
					return element;
				}
				else
				{
					return null;
				}
			}
		});

		return wb;
	}

	//----------------------------------------------------------------------------
	//Fetching the attribute value from Web Element
	//----------------------------------------------------------------------------
	public String getAttributeValue(WebElement element, String attribute)
	{
		String attributeValue="";
		try
		{
			attributeValue = element.getAttribute(attribute);

		}catch(Exception e){e.printStackTrace();}
		return attributeValue;
	}

	//----------------------------------------------------------------------------
	//Validating String
	//----------------------------------------------------------------------------

	public void validateString(String expMsg,String actMsg,String message)
	{
		Assert.assertEquals(actMsg, expMsg);
		Reporter.log(message,true);
	}



	//----------------------------------------------------------------------------
	//Page Title Validation
	//----------------------------------------------------------------------------

	public void validatePageTitle(String expMsg,String message)
	{
		String actMsg = driver.getTitle();
		validateString(expMsg, actMsg, message);
	}


	//----------------------------------------------------------------------------
	//Get total Responses
	//----------------------------------------------------------------------------

	public int getNewResponseNumber()
	{
		int numberOfResponses = 0;
		try
		{
			eWaitForAllElementPresent(20, By.xpath("(//div[@data-activity-id]//p)"));
			List<WebElement> allResponses = driver.findElements(By.xpath("(//div[@data-activity-id]//p)"));
			numberOfResponses = allResponses.size()+1;
		}
		catch (NoSuchElementException | NullPointerException | TimeoutException e) 
		{
			e.printStackTrace();
			numberOfResponses = 0;
		}
		return numberOfResponses;
	}


	//----------------------------------------------------------------------------
	//Latest Page Response Validation
	//----------------------------------------------------------------------------
	public String getLatestResponse(int newLen)
	{
		String actualText=null;
		try
		{
			eWaitForPresent(30, By.xpath("(//div[@data-activity-id]//p)["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("(//div[@data-activity-id]//p)["+newLen+"]"));
			actualText = wb.getText();
			System.out.println(actualText);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{
			e.printStackTrace();
			actualText =  "";
		}

		return actualText;

	}
	
	//----------------------------------------------------------------------------
	//Latest Page Response Validation For Dashboards
	//----------------------------------------------------------------------------
	public String getLatestResponseFOrDashboards(int newLen)
	{
		String actualText=null;
		try
		{
			eWaitForPresent(20, By.xpath("(//div[@data-activity-id]//p)["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("(//div[@data-activity-id]//p)["+newLen+"]"));
			newLen=newLen+1;
			eWaitForPresent(20, By.xpath("(//div[@data-activity-id]//p)["+newLen+"]"));
			actualText = wb.getText();
			System.out.println(actualText);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{
			e.printStackTrace();
			actualText =  "";
		}

		return actualText;

	}

	//----------------------------------------------------------------------------
	//Get total OpenInWeb Responses
	//----------------------------------------------------------------------------

	public int getTotalOpenInWebResponses()
	{
		int latestOpenInWebResponseNumber = 0;
		try
		{
			eWaitForAllElementPresent(5, By.xpath("(//div[@data-activity-id]//p)/../../..//button[text()='Open in Web']"));
			List<WebElement> allResponses = driver.findElements(By.xpath("(//div[@data-activity-id]//p)/../../..//button[text()='Open in Web']"));
			latestOpenInWebResponseNumber = allResponses.size()+1;
		}
		catch (NoSuchElementException | NullPointerException | TimeoutException e) 
		{
			e.printStackTrace();
			latestOpenInWebResponseNumber = 1;
		}
		return latestOpenInWebResponseNumber;
	}
	
	
	//----------------------------------------------------------------------------
	//Latest Page Response Validation
	//----------------------------------------------------------------------------
	public void clickOnLatestOpenInWeb(int newLen,String pageTitle)
	{
		try
		{
			eWaitForPresent(20, By.xpath("((//div[@data-activity-id]//p)/../../..//button[text()='Open in Web'])["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("((//div[@data-activity-id]//p)/../../..//button[text()='Open in Web'])["+newLen+"]"));
			clickElement(wb);
			windowHandlingOpenInWeb(pageTitle);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------
	//Window Handling for Open In Web
	//----------------------------------------------------------------------------
	
	public void windowHandlingOpenInWeb(String pageTitle)
	{
		try
		{
			String parentWindow = driver.getWindowHandle();
			Set<String> totalWindows = driver.getWindowHandles();
			ArrayList<String> windowHandles = new ArrayList<>(totalWindows);
			String childWindow = windowHandles.get(1);
			driver.switchTo().window(childWindow);
			driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//----------------------------------------------------------------------------
	//Get total OpenInPdf Responses
	//----------------------------------------------------------------------------

	public int getTotalOpenInPdfResponses()
	{
		int latestOpenInWebResponseNumber = 0;
		try
		{
			eWaitForAllElementPresent(5, By.xpath("(//div[@data-activity-id]//p)/../../..//button[text()='Open in Pdf']"));
			List<WebElement> allResponses = driver.findElements(By.xpath("(//div[@data-activity-id]//p)/../../..//button[text()='Open in Pdf']"));
			latestOpenInWebResponseNumber = allResponses.size()+1;
		}
		catch (NoSuchElementException | NullPointerException | TimeoutException e) 
		{
			e.printStackTrace();
			latestOpenInWebResponseNumber = 1;
		}
		return latestOpenInWebResponseNumber;
	}
	
	
	//----------------------------------------------------------------------------
	//Click on Latest Open In PDF
	//----------------------------------------------------------------------------
	
	public void clickOnLatestOpenInPdf(int newLen, String pageTitle)
	{
		try
		{
			eWaitForPresent(20, By.xpath("((//div[@data-activity-id]//p)/../../..//button[text()='Open in Pdf'])["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("((//div[@data-activity-id]//p)/../../..//button[text()='Open in Pdf'])["+newLen+"]"));
			clickElement(wb);
			windowHandlingOpenInWeb(pageTitle);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{

			e.printStackTrace();
		}

	}
	
	//----------------------------------------------------------------------------
	//Window Handling for Open In Pdf
	//----------------------------------------------------------------------------
	
	public void windowHandlingOpenInPdf(String pageTitle)
	{
		try
		{
			String parentWindow = driver.getWindowHandle();
			Set<String> totalWindows = driver.getWindowHandles();
			ArrayList<String> totalWindowHandles = new ArrayList<>(totalWindows);
			String childWindow = totalWindowHandles.get(1);
			driver.switchTo().window(childWindow);
			driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	//----------------------------------------------------------------------------
	//Get total OpenInWeb Responses
	//----------------------------------------------------------------------------

	public int getTotalOpenLinkResponses()
	{
		int latestOpenInWebResponseNumber = 0;
		try
		{
			eWaitForAllElementPresent(5, By.xpath("(//button[text()='Open link'])"));
			List<WebElement> allResponses = driver.findElements(By.xpath("(//button[text()='Open link'])"));
			latestOpenInWebResponseNumber = allResponses.size()+1;
		}
		catch (NoSuchElementException | NullPointerException | TimeoutException e) 
		{
			e.printStackTrace();
			latestOpenInWebResponseNumber = 1;
		}
		return latestOpenInWebResponseNumber;
	}
	
	
	//----------------------------------------------------------------------------
	//Latest Page Response Validation
	//----------------------------------------------------------------------------
	public void clickOnLatestOpenLinkForDirection(int newLen,String pageTitle)
	{
		try
		{
			eWaitForPresent(20, By.xpath("(//button[text()='Open link'])["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("(//button[text()='Open link'])["+newLen+"]"));
			clickElement(wb);
			windowHandlingOpenLink(pageTitle);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------
	//Latest Page Response Validation
	//----------------------------------------------------------------------------
	public void clickOnLatestOpenLinkForRestaurants(int newLen,String pageTitle)
	{
		newLen=newLen+1;
		try
		{
			eWaitForPresent(20, By.xpath("(//button[text()='Open link'])["+newLen+"]"));
			WebElement wb = driver.findElement(By.xpath("(//button[text()='Open link'])["+newLen+"]"));
			clickElement(wb);
			windowHandlingOpenLink(pageTitle);
		}
		catch(NullPointerException | NoSuchElementException | TimeoutException e)
		{
			e.printStackTrace();
		}
	}
	
	
	//----------------------------------------------------------------------------
	//Window Handling for Open Link
	//----------------------------------------------------------------------------
	
	public void windowHandlingOpenLink(String pageTitle)
	{
		try
		{
			String parentWindow = driver.getWindowHandle();
			Set<String> totalWindows = driver.getWindowHandles();
			ArrayList<String> windowHandles = new ArrayList<>(totalWindows);
			String childWindow = windowHandles.get(1);
			driver.switchTo().window(childWindow);
			driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//----------------------------------------------------------------------------
	//Window Handling for Open Link
	//----------------------------------------------------------------------------
	
	public void windowHandlingReport(String pageTitle)
	{
		try
		{
			String parentWindow = driver.getWindowHandle();
			Set<String> totalWindows = driver.getWindowHandles();
			ArrayList<String> windowHandles = new ArrayList<>(totalWindows);
			String childWindow = windowHandles.get(1);
			driver.switchTo().window(childWindow);
			driver.getTitle();
			driver.close();
			driver.switchTo().window(parentWindow);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	
	
	
	
	//----------------------------------------------------------------------------
	//Click on the button displayed in response
	//----------------------------------------------------------------------------

	public void clickOnTxtBtnMsg(String textToClick)
	{
		List<WebElement> allLists = driver.findElements(By.xpath("//div[@class='wc-list']"));
		int i = allLists.size()-1;
		List<WebElement> buttons = driver.findElements(By.xpath("(//div[@class='wc-list'])["+i+"]//button"));

		for(int j=0;j<buttons.size()-1;j++)
		{

			String buttonTxt = buttons.get(j).getText();
			if(buttonTxt.equalsIgnoreCase(textToClick))
			{
				clickElement(buttons.get(j));
			}

		}
	}


	//----------------------------------------------------------------------------
	//Scrolling
	//----------------------------------------------------------------------------
	public void scrollToElement(WebElement element)
	{
		String jsCode="arguments[0].scrollIntoView()";
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript(jsCode, element);
	}



	//----------------------------------------------------------------------------
	//Getting substring from data activity Id
	//----------------------------------------------------------------------------

	public String dataIdSubstring()
	{
		List<WebElement> allLists = driver.findElements(By.xpath("//div[@class='wc-message-group-content']/div"));
		int i = allLists.size()-1;
		WebElement latestResponse = driver.findElement(By.xpath("//div[@class='wc-message-group-content']/div["+i+"]"));
		String dataActivityId = getAttributeValue(latestResponse,"data-activity-id");
		String id=dataActivityId.substring(dataActivityId.length()-7);
		return id;
	}
}