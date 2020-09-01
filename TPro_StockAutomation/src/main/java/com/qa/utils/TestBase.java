/*
 * Author: Prateek Nehra
 * 
 */

package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.pageHelper.Home_PageHelper;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	protected static Home_PageHelper obj;
	public TestBase () {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\WSPACE\\eclipse-workspace\\eclipse\\Terminus_StockAutomation\\"
					+ "src\\main\\java\\com\\qa\\config\\Config.properties");
			prop.load(fis);
		}catch (IOException e) {
			e.getMessage();
		}
		
	}
	
	
public static void Initialization() {
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")) {
		
		// To fetch the severe JS errors
		DesiredCapabilities capibilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingPreferences = new LoggingPreferences();
		loggingPreferences.enable(LogType.BROWSER, Level.SEVERE);
		capibilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
		
	// Code for Selenium Grid to execute cross browser test using hub and nodes
//		String hubUrl = "http://10.1.30.33:4444/wd/hub";     //Hub URL
//		driver = new RemoteWebDriver(new URL(hubUrl),capibilities);
		
		System.setProperty("webdriver.chrome.driver","C:\\WSPACE\\Driver\\chromedriver.exe");
	driver = new ChromeDriver(capibilities);	
	}
	else if(browserName.equals("IE")) {
		System.setProperty("webdriver.chrome.driver","C:\\WSPACE\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	obj = new Home_PageHelper(driver);
		
}

public String getReportConfigPath(){
String reportConfigPath = prop.getProperty("reportConfigPath");
if(reportConfigPath!= null) return reportConfigPath;
else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}

@Before
public void setUp(Scenario scenario)
{
}

}

