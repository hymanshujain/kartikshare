
package com.qa.stepDefinition;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps extends TestBase {

	LoginPage loginPage;
	HomePage homePageObject;
	

	// Test Cases should be separated -- independent with each other
	// Before each test case -- launch the browser and login
	// after each test case -- close the browser

	 @Given("^user open browser$")
	 public void user_open_browser() {
	 Initialization();
	 }

	 @Then("^user is on login page$")
	 public void validateUserIsOnLoginPage() {
	 loginPage = new LoginPage();
	 String title = loginPage.validateLoginPageTitle();
	 Assert.assertEquals("Terminus", title);
	 }
	
	 @Then("^user logs into app$")
	 public void enterUserCredentials() throws InterruptedException {
	homePageObject = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	
	 }
	 
	 @Then("^click on KPIMenu$")
		public void openKpiMenu() throws Exception {
		 obj.openKpiMenu();
		 Thread.sleep(2000);
		}

	@Given("^user is on home page$")
	public void validate_home_page_NewDashboard_Icon() {
		//homePage = new HomePage();
		Boolean flag = obj.verifyNewDashIcon();
		Assert.assertTrue(flag);
	}

	@Then("^validate home page DashboardSettings Icon$")
	public void validate_home_page_DashboardSettings_Icon() {
		Assert.assertTrue(obj.verifyDashSettingsIcon());
	}

		
//	@Then("^turn ON openOutside$")
//	public void turnOnOpenOutside() throws InterruptedException {
//		homePage.clickDashSettings();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		Thread.sleep(5000);
//		homePage.clickOpenOutSide();
//		Thread.sleep(5000);
//		//to return focus back on dashboard
//		homePage.clickDashMenuToReturnFocus();
//		homePage.clickDashSettings();
//		Thread.sleep(5000);
//	}
	

	@Then("^open a KPI$")
	public void openKpi() throws InterruptedException {
		// NOTE KPI NAME IS HARDCODED..... so created below method in page class and call desired KPI name through parameter
		//driver.findElement(By.xpath("//div[@itemname='Admin Hours and Amount']")).click();		
		
//			if(homePage.checkIfNewDashboardPresent()) {
//				homePage.findKPIAndOpen("Admin Hours and Amount");
//			}else {
//				homePage.openNewDashboard();
//				homePage.findKPIAndOpen("Admin Hours and Amount");
//			}
				
		obj.openNewDashboard();	
		obj.findKPIAndOpen("Admin Hours and Amount");  //  Admin Hours and Amount  Billed Hours to Worked Hours
		obj.waitToLoad();
		
	}
	

	@Then("^verify KPi is open without error$")
	public void verify_KPi_is_open_without_error() throws InterruptedException {
		Thread.sleep(3000);
		obj.verifyKpiIsOpen();
		System.out.println("KPI open SUCCESS");
	}
	
	@Then("^Open Radial Menu and DD by any option$")
	public void open_Radial_Menu_and_DD_by_any_option() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		obj.findKpiAreaAndRightClickToOpenRadialMenuAndThenDD(3);
		System.out.println("DD SUCCESS");
	}

	
	@Then("^open the report view$")
	public void open_the_report_view() throws InterruptedException {
		obj.openReportViewFromKpi();
		System.out.println("Report OPen SUCCESS");
	}

	@Then("^full view and add dimension$")
	public void full_view_and_add_dimension() throws InterruptedException {
		obj.AddDimension();
		System.out.println("Add Dimension SUCCESS");
	}
	@Then("^close the browser$")
	public void close_the_browser() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	@Given("^KPI menu is open$")
	public void kpi_Menu_Is_Open (){
		
	}
		
	@Then("^open a dashboard$")
	public void open_a_dashboard () throws InterruptedException {
		obj.openDashboard();
		Thread.sleep(5000);
	}
	@Then("^close the browser1$")
	public void close_the_browser1() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	@Given("^user is on home page again$")
	public void user_is_onhome_page_again() {
		
	}

	//open all KPI's and verify if all KPI's open without any error
	@Then("^user open all KPI's$")
	public void User_open_All_KPIs() throws InterruptedException {
		obj.openNewDashboard();	
		obj.open_All_KPI_s();
		    		
	}

	@Then("^Close the browser$")
	public void close_the_browser11() {
		driver.close();
		
	}
	
	// Open All the dashboards
	@Given("^Dashboard Tab is open in KPI menu$")
	public void dashboard_Tab_is_open_in_KPI_menu() {
		
	}

	@Then("^open all the dashboards$")
	public void user_open_all_the_dashboards() throws InterruptedException {
		obj.open_all_the_dashboards();
	}
	
	//DD by all the options on KPI
	@Given("^User is logged in and KPI menu is open$")
	public void user_is_logged_in_and_KPI_menu_is_open() {
		
	}

	@Then("^open the KPI$")
	public void open_the_KPI() throws InterruptedException {
		obj.openNewDashboard();	
		obj.findKPIAndOpen("Billed Hours to Worked Hours"); //  Billed Hours to Worked Hours  Admin Hours and Amount
	}

	@Then("^DD by all the options$")
	public void dd_by_all_the_options() throws InterruptedException {
		obj.ddByAllOptionsOnKPI();
	}

	@Then("^quit the browser$")
	public void quit_the_browser() {
		driver.close();
	}
	
	@Given("^KPI is open$")
	public void kpi_is_open() throws InterruptedException {
		Thread.sleep(2000);
		obj.openNewDashboard();	
		obj.OpenKPI();
//		obj.findKPIAndOpen("Admin Hours and Amount");   //Billed Hours to Worked Hours   Admin Hours and Amount
		
	}

	@Then("^Open report view and full view$")
	public void open_report_view_and_full_view() throws InterruptedException {
		obj.openReportViewFromKpi();
		System.out.println("Report Open SUCCESS");
	}

	@Then("^Add all the dimensions$")
	public void add_all_the_dimensions() throws InterruptedException {
		Thread.sleep(1000);
		obj.addAllDimensionsOnReport();
	}
	
		
	
	//Scenario to add all the dimensions on all KPI's report 
	@Given("^KPI is already Open$")
	public void kpi_is_already_Open() throws InterruptedException  {
		Thread.sleep(2000);
		obj.openNewDashboard();	
		obj.openReportAddDim();
	   
	}

	@Then("^Open report view from KPI and full view$")
	public void open_report_view_from_KPI_and_full_view()  {
	   
	}

	@Then("^Add all the dimensions and close the report$")
	public void add_all_the_dimensions_and_close_the_report()  {
	    
	}
	

	//## --- Scenario to add measure on KPI --
	@Given("^User is logged in and KPI Menu is Open$")
	public void user_is_logged_in_and_KPI_Menu_is_Open() {

	}

	@Then("^Open a KPI$")
	public void open_a_KPI() throws InterruptedException {
		obj.OpenKPI();

	}

	@Then("^Click the Show Measures Icon on KPI Menu$")
	public void click_the_Show_Measures_Icon_on_KPI_Menu()  {
		obj.addMeasure();

	}

	@Then("^Pick a measure from measure list and add to KPI$")
	public void pick_a_measure_from_measure_list_and_add_to_KPI()  {

	}
	
	//## -- Scenario to add columns to super Header and set measure column as under header
	
	@Given("^User is logged in and Report is open$")
	public void user_is_logged_in_and_Report_is_open() throws InterruptedException {
		obj.OpenKPI();
		obj.openReportViewFromKpi();		
	}

	@Then("^Add Dimension One$")
	public void add_Dimension_One() throws InterruptedException {
		obj.AddDimension();
				
	}

	@Then("^Add Dimension Two$")
	public void add_Dimension_Two() throws InterruptedException {
		obj.AddDimension();
	}

	@Then("^Set Dimension One as super header$")
	public void set_Dimension_One_as_super_header() throws InterruptedException {
		obj.setDimAsSuperHeader();
		
	}

	@Then("^Set Dimension Two as super header$")
	public void set_Dimension_Two_as_super_header() throws InterruptedException {
		//obj.setDimAsSuperHeader();
		
	}
	
	@Then("^Set measure column as set under header$")
	public void set_measure_column_as_set_under_header() {
		
		
	}
	
	
	// Scenario to apply parameter Search
	@Given("^Report view is open$")
	public void report_view_is_open() throws InterruptedException {
		
		obj.openNewDashboard();
		obj.OpenKPI();
		obj.openReportViewFromKpi();
		
		
	}

	@Then("^click on Parameter search Icon$")
	public void click_on_Parameter_search_Icon() {
		obj.clickParaMeterSearchIcon();
	}
	

	@Then("^select an option$")
	public void select_and_option() {
		obj.selectPrarmeterSearchValue();
	}

	@Then("^Enter a value and click search$")
	public void enter_a_value_and_click_search() {
		obj.enterParameterFilterValue();
		
	}

	@Then("^verify report data gets filtered as per search criteria$")
	public void verify_report_data_gets_filtered_as_per_search_criteria() {
	}
	
	//Scenario to apply formulae on report
	@Given("^KPI is open already$")
	public void kpi_is_open_already() throws InterruptedException {
		obj.OpenKPI();
		
	}

	@Then("^Add measure$")
	public void add_measure() {
		obj.addMeasure();
		
	}
	
	@Then("^Open report view$")
	public void open_report_view() throws InterruptedException {
		obj.openReportViewFromKpi();
		
	}

	@Then("^apply formulae$")
	public void apply_formulae() throws InterruptedException {
		Thread.sleep(1000);
		obj.applyFormulae();	
		
	}
	
	
}
