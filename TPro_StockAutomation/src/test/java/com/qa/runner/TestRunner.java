/*
 * Author: Prateek Nehra
 * 
 */

package com.qa.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import com.qa.utils.TestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-html-report.html"},
		features = "C:\\WSPACE\\eclipse-workspace\\eclipse\\Terminus_StockAutomation\\src\\test\\java\\com\\qa\\features"  //the path of the feature file
		,glue={"com/qa/stepDefinition","com.qa.runner","com.qa.config","com.qa.features","com.qa.pageHelper","com.qa.pages","com.qa.utils"}, //the path of the step definition
		format= {"pretty","html:test-outout","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"}, //to generate different type of reporting
		monochrome = true, //display the console output in a readable format
		strict = true, //it will check if any step is not defined in step definition file and stop the execution if any steps missing
		dryRun = false, //to check the mapping is proper in step definition file.. it checks the mapping without actually execution
		tags = {"@Smoke", "@Regression", "@Sample"}
		)

public class TestRunner extends TestBase {
	
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent_config.xml"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "  64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.5.2");
	    Reporter.setSystemInfo("Maven", "3.3.9");
	    Reporter.setSystemInfo("Java Version", "1.8.0_191");
	    Reporter.setSystemInfo("APP URL", prop.getProperty("url"));
	}

	
	
}



        //ORed = tags = {"@SmokeTest,@RegressionTest"}
		//ANDed = tags = {"@SmokeTest","@RegressionTest"}
        //Ignore = tags = {"~@SmokeTest","@RegressionTest"}   tilde will exclude/ignore Smoke test to execute so this will only execute scenarios which 
															//are tagged as @RegressionTest
