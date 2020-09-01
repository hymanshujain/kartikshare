package com.qa.stepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.qa.pageHelper.LoggerHelper;
import com.qa.utils.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.cucumber.listener.Reporter;


public class ServiceHooks {

	TestBase testBase;

	Logger log = LoggerHelper.getLogger(ServiceHooks.class);

	 @Before
	 public void beforeScenario(Scenario scenario) {
//		DesiredCapabilities capibilities = DesiredCapabilities.chrome();
//		LoggingPreferences loggingPreferences = new LoggingPreferences();
//		loggingPreferences.enable(LogType.BROWSER, Level.SEVERE);
//		capibilities.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
//		System.setProperty("webdriver.chrome.driver","D:\\DigitalEye\\Automation\\chromedriver.exe");
//		TestBase.driver = new ChromeDriver(capibilities);
	 }

	@After
	public void endTest(Scenario scenario) {

		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				log.info(scenario.getName() + " is Failed");
				//This takes a screenshot from the driver and save it to the specified location
				File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
				
				//Building up the destination path for the screenshot to save
				//Also make sure to create a folder 'screenshots' with in the cucumber-report folder
				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
				//Copy taken screenshot from source location to destination location
				//Files.copy(sourcePath, destinationPath);
				FileUtils.copyFile(sourcePath, destinationPath);
              //This attach the specified screenshot to the test
			    Reporter.addScreenCaptureFromPath(destinationPath.toString());
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			try {
//				log.info(scenario.getName() + " is pass");
//				File sourcePath = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
//
//				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".png");
//				FileUtils.copyFile(sourcePath, destinationPath);
//			    Reporter.addScreenCaptureFromPath(destinationPath.toString());
//				
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}


		TestBase.driver.quit();
	}

}
