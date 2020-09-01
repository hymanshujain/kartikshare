package com.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GeneralHooks {
	
	Scenario scenario;
	static WebDriver driver;
	//1.Create the public method
	//2. Use the @Before & @After annotations with the methods
	//3. Specify the package in the runner
	//4. Inject the Scenario Object in the hook method
	
	@Before
	public void seUp(Scenario scenario)
	{
		this.scenario=scenario;
		Reporter.assignAuthor("Gyan");
	}
	
	@After
	public void quitDriver() throws IOException
	{
		if(scenario.isFailed())
		{
			System.out.println("Scenario Name Is: "+scenario.getName());
			Reporter.addScreenCaptureFromPath(captureScreenshot());
			//driver.quit();
		}
		
		System.out.println("Scenario Name Is: "+scenario.getName());
		Reporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" +" " + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	    
	   /* Reporter.setSystemInfo("Application URL", propertyReader.readApplicationFile("URL"));
	    Reporter.setSystemInfo("Database Server", propertyReader.readApplicationFile("DBSERVER"));
	    Reporter.setSystemInfo("Database Name", propertyReader.readApplicationFile("DBNAME"));*/
		//driver.quit();
	}

	//---------------------------------------------------------------------------------------------------------
	//Get absolute path
	//---------------------------------------------------------------------------------------------------------
	
	
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");		
		return path;
	}

	public String captureScreenshot() throws IOException
	{
		String scnarioName="";
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		scnarioName = scenario.getName().replace(" ","_");
		File DestFile=new File(System.getProperty("user.dir")+"/screenshots/"+scnarioName+".png");
		FileUtils.copyFile(SrcFile, DestFile);
		return System.getProperty("user.dir")+"/screenshots/"+scnarioName+".png";

	}
	
}
