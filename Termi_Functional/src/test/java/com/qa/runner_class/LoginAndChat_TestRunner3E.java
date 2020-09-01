package com.qa.runner_class;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
	    features= {"src/main/java/com/qa/feature/loginAndChat3e.feature"},
	    glue= {"com/qa/step_Definition_3E","com.qa.util","com.qa.pageobject"},
	    plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:./TermiExtent.html"},
	    monochrome=true,
	    dryRun=false
	    )

public class LoginAndChat_TestRunner3E
{
	
	@BeforeClass
	public void test()
	{
		System.out.println("3E_Execution Started");
	}

	
	@Test
	public void runCukes1()
	{
		new TestNGCucumberRunner(getClass()).runCukes();
	}

	
}
