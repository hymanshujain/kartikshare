package com.qa.step_Definition_3E;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.pageobject.ChatBotPage;
import com.qa.pageobject.DashboardPage;
import com.qa.pageobject.LoginPage;
import com.qa.step_definition.TestBase;
import com.qa.util.DriverFactory;
import com.qa.util.Excel;
import com.qa.util.ExcelDataToDataTable;
import com.qa.util.GeneralHooks;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginAndChat_Step_Definition3E extends TestBase
{	public static int newResponseLength ;
	static LoginPage lp;
	static DashboardPage dbp;
	static ChatBotPage cbp;
	GeneralHooks generalHooks;
	

	public LoginAndChat_Step_Definition3E() 
	{	
		generalHooks = new GeneralHooks();
	}

@Given("^Launch Termi in Google Chrome$")
	public void launch_termi_in_google_chrome()
	{

		driver=DriverFactory.launch("Chrome");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://termistaging.helm360.com/Termi/home/login");

	}

@When("^Enter Username and Password from excel at \"([^\"]*)\"$")
public void enter_username_and_password_from_excel_at(@Transform(ExcelDataToDataTable.class) DataTable table) 
	{
		System.out.println(table.toString());
		List<String> dataList = table.asList(String.class);
		lp= new LoginPage(driver);
		lp.login(dataList.get(0), dataList.get(1));
	}

@When("^Click on Login Button$")
public void click_on_login_button()
	{
		lp.clickOnLoginBtn();
	}

@When("^Click on Chat icon$")
public void click_on_chat_icon()
	{
		dbp =new DashboardPage(driver);
		dbp.clickOnChatIcon();
	}

@Then("^Verify that we are on chat page with page title \"([^\"]*)\"$")
public void verify_that_we_are_on_chat_page(String title) throws InterruptedException
	{
		cbp= new ChatBotPage(driver);
		cbp.verifyChatPage(title);
		Thread.sleep(5000);
	}

@Then("^User enters Question and gets Answer from excel at \"([^\"]*)\"$")
public void user_enters_question_and_gets_answer_from_excel(@Transform(ExcelDataToDataTable.class) DataTable table)
	{
		//		SoftAssert sa = new SoftAssert();
		XSSFWorkbook wb=Excel.getQAWorkbook();
		XSSFSheet sh=Excel.getOrCreateSheet(wb, "Question_Answer_Results_3E");

		List<String> dataList = table.asList(String.class);
		int totalCells = dataList.size();
		int counter=0 ;
		System.out.println("Total Rows : "+totalCells/2);
		for(int i=1; i<=totalCells/2; i++)
		{
          try
			{
				
				String actualResponse;
				String expectedResponse;
				int totalOpenInWebResponses = cbp.getTotalOpenInWebResponses();
				int totalOpenInPdfResponses = cbp.getTotalOpenInPdfResponses();
				int totalOpenLinkResponses = cbp.getTotalOpenLinkResponses();
				switch (dataList.get(counter)) 
				{
				case "Professional Dashboards":
					newResponseLength=cbp.sendUsrMsg(dataList.get(counter));
					Reporter.addStepLog("  User Enters Question : "+dataList.get(counter));
					actualResponse = cbp.getLatestResponseFOrDashboards(newResponseLength);
					expectedResponse = dataList.get(counter+1);
					Reporter.addStepLog("User Should Get Answer : "+dataList.get(counter+1)+"\n          And User Got : "+actualResponse);
					break;


				case "Firm Level Dashboards":
					newResponseLength=cbp.sendUsrMsg(dataList.get(counter));
					Reporter.addStepLog("  User Enters Question : "+dataList.get(counter));
					actualResponse = cbp.getLatestResponseFOrDashboards(newResponseLength);
					expectedResponse = dataList.get(counter+1);
					Reporter.addStepLog("User Should Get Answer : "+dataList.get(counter+1)+"\n          And User Got : "+actualResponse);
					break;


				default:
					newResponseLength=cbp.sendUsrMsg(dataList.get(counter));
					Reporter.addStepLog("  User Enters Question : "+dataList.get(counter));
					actualResponse = cbp.getLatestResponse(newResponseLength);
					expectedResponse = dataList.get(counter+1);
					Reporter.addStepLog("User Should Get Answer : "+dataList.get(counter+1)+"\n          And User Got : "+actualResponse);
					break;
				}
				/*newResponseLength=cbp.sendUsrMsg(dataList.get(counter));
				Reporter.addStepLog("  User Enters Question : "+dataList.get(counter));
				String actualResponse = cbp.getLatestResponse(newResponseLength);
				String expectedResponse = dataList.get(counter+1);
				Reporter.addStepLog("User Should Get Answer : "+dataList.get(counter+1)+"\n          And User Got : "+actualResponse);*/
				//				sa.assertTrue(actualResponse.contains(expectedResponse));


				if(actualResponse.contains(expectedResponse) && dataList.get(counter+2).equalsIgnoreCase("Open In Web") )
				{
					Excel.writeResultsInExcel(sh, i, 2, actualResponse);
					Excel.writeResultsInExcel(sh, i, 3, "Pass");
					String pageTitle =dataList.get(counter+3);
					cbp.clickOnOpenInWeb(totalOpenInWebResponses, pageTitle);
					Excel.writeResultsInExcel(sh, i+1, 2, "");
					Excel.writeResultsInExcel(sh, i+1, 3, "Pass");
					pageTitle =dataList.get(counter+5);
					cbp.clickOnOpenInPdf(totalOpenInPdfResponses, pageTitle);
					Excel.writeResultsInExcel(sh, i+2, 2, "");
					Excel.writeResultsInExcel(sh, i+2, 3, "Pass");
					Reporter.addStepLog("       Result : Passed");
					i=i+2;   //This line will skip 2 rows which we do not want to execute
					counter=counter+6;

				}

				else if(actualResponse.contains(expectedResponse) && dataList.get(counter).contains("Dashboards") )
				{
					Excel.writeResultsInExcel(sh, i, 2, actualResponse);
					Excel.writeResultsInExcel(sh, i, 3, "Pass");
					Reporter.addStepLog("        Result : Passed");
					counter= counter+2;

				}

				else if(actualResponse.contains(expectedResponse) && dataList.get(counter+2).equalsIgnoreCase("Open Link") )
				{
					Excel.writeResultsInExcel(sh, i, 2, actualResponse);
					Excel.writeResultsInExcel(sh, i, 3, "Pass");
					String pageTitle =dataList.get(counter+3);
					cbp.clickOnOpenLinkForDirection(totalOpenLinkResponses, pageTitle);
					Excel.writeResultsInExcel(sh, i+1, 2, "");
					Excel.writeResultsInExcel(sh, i+1, 3, "Pass");
					pageTitle =dataList.get(counter+5);
					cbp.clickOnOpenLinkForRestaurants(totalOpenLinkResponses, pageTitle);
					Excel.writeResultsInExcel(sh, i+2, 2, "");
					Excel.writeResultsInExcel(sh, i+2, 3, "Pass");
					Reporter.addStepLog("         Result : Passed");
					i=i+2;   //This line will skip 2 rows which we do not want to execute
					counter=counter+6;

				}

				else if(actualResponse.contains(expectedResponse) )
				{
					Excel.writeResultsInExcel(sh, i, 2, actualResponse);
					Excel.writeResultsInExcel(sh, i, 3, "Pass");
					Reporter.addStepLog("         Result : Passed");
					counter= counter+2;

				}


				else
				{
					if(dataList.get(counter+2).equalsIgnoreCase("Open In Web") || dataList.get(counter+2).equalsIgnoreCase("Open Link") )
					{
						Excel.writeResultsInExcel(sh, i, 2, actualResponse);
						Excel.writeResultsInExcel(sh, i, 3, "Fail");
						Excel.writeResultsInExcel(sh, i+1, 2, "");
						Excel.writeResultsInExcel(sh, i+1, 3, "Fail");
						Excel.writeResultsInExcel(sh, i+2, 2, "");
						Excel.writeResultsInExcel(sh, i+2, 3, "Fail");
						Reporter.addStepLog("       Result : Failed");
						i=i+2;       //This line will skip 2 rows which we do not want to execute
						counter=counter+6;
					}
					else
					{
						Excel.writeResultsInExcel(sh, i, 2, actualResponse);
						Excel.writeResultsInExcel(sh, i, 3, "Fail");
						Reporter.addStepLog("       Result : Failed");
						counter=counter+2;
					}
				}


			}

			catch(NoSuchElementException | NullPointerException e)
			{
				if(dataList.get(counter+2).equalsIgnoreCase("Open In Web") || dataList.get(counter+2).equalsIgnoreCase("Open Link") )
				{
					Excel.writeResultsInExcel(sh, i, 2, "");
					Excel.writeResultsInExcel(sh, i, 3, "Fail");
					Excel.writeResultsInExcel(sh, i+1 ,2, "");
					Excel.writeResultsInExcel(sh, i+1, 3, "Fail");
					Excel.writeResultsInExcel(sh, i+2, 2, "");
					Excel.writeResultsInExcel(sh, i+2, 3, "Fail");
					Reporter.addStepLog("         Result : Failed");
					i=i+2;        //This line will skip 2 rows which we do not want to execute
					counter=counter+6;
				}
				else
				{
					Excel.writeResultsInExcel(sh, i, 2, "");
					Excel.writeResultsInExcel(sh, i, 3, "Fail");
					Reporter.addStepLog("         Result : Failed");
					counter=counter+2;
				}
				e.printStackTrace();
			}

			catch(IndexOutOfBoundsException e)
			{
				e.printStackTrace();
				//When all code will get executed this will handle IndexOutOfBoundException

			}
			Reporter.addStepLog("\n\n\n");

		}
		//		sa.assertAll();
	}

@Then("^close the browser$")
public void close_the_browser()
	{
		driver.close();
	}
}