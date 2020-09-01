package com.qa.runner_class;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
	    features= {"src/main/java/com/qa/feature/loginAndChat.feature"},
	    glue= {"com.qa.step_definition","com.qa.util","com.qa.pageobject"},
	    plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:./TermiExtent.html"},
	    monochrome=true,
	    dryRun=false
	    )

public class LoginAndChat_TestRunner
{
	
	@BeforeClass
	public void test()
	{
		System.out.println("Execution Started");
	}

	
	@Test
	public void runCukes()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
	}

	
}
