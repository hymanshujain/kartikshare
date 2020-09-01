//package com.qa.stepDefinition;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.Assert;
//
//import com.qa.pages.HomePage;
//import com.qa.pages.LoginPage;
//import com.qa.utils.TestBase;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//
//public class LoginPageSteps extends TestBase {
//
//	LoginPage loginPage;
//	HomePage homePage;
//
//	@Given("^user open browser$")
//	public void user_open_browser() {
//		TestBase.Initialization();
//	}
//
//	@Then("^user is on login page$")
//	public void validateUserIsOnLoginPage() {
//		loginPage = new LoginPage();
//		String title = loginPage.validateLoginPageTitle();
//		Assert.assertEquals("Terminus", title);
//	}
//
//	@Then("^user logs into app$")
//	public void enterUserCredentials() {
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//
//	}
//
//	@Then("^close the browser$")
//	public void close_the_browser() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.quit();
//	}
//
//}
