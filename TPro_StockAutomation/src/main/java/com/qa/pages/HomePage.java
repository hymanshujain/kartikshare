package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.utils.TestBase;

public class HomePage extends TestBase {
	
	protected WebDriver driver;
	//CREATED PARAMETERIZED CONSTRUCTOR AND PASSING DRIVER INTO IT
	public HomePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='New Dashboard']")
	protected	WebElement newDashboardIcon;

	@FindBy(xpath = "//div[@id='ritemDashtoolbar' and @title='Dashboard Settings']")
	protected WebElement dashSettings;

	@FindBy(xpath = "//*[@class='appHeader-icons kpimenu']")
	protected WebElement kpiMenuOff;
	
	@FindBy(xpath = "//*[@class='appHeader-icons kpimenu-open']")
	protected WebElement kpiMenuON;

	@FindBy(xpath = "//div[@title='Swap Axis']")
	protected WebElement swapAxisIcon;

	//KPI are to mouse hover to make KPI settings and other icons visible
	//--//img[@class='zc-img' and  @src=\"data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==\"]
	@FindBy(xpath = "//*[@class='zc-img']")
	protected WebElement kpiAreaToRightClick;

	@FindBy(xpath = "//*[@class='i-dark-drill-down']")
	protected WebElement radialMenuBtn;

	//*[contains(@id,'Canvas')]//*[name()='svg' and @id = 'defaultID']//*[@class='i-dark-drill-down']
	//div[contains(@id,'Canvas')]//*[@id='defaultID']//*[@id='g']//preceding-sibling::*//descendant::*[contains(@id,'PBtn12')]//descendant::*[contains(@class,'i-dark-drill-down')]
	@FindBy(xpath = "//*[contains(@id,'Canvas')]//*[name()='svg' and @id = 'defaultID']//*[name()='foreignObject' and contains(@id,'PBtn12')]/html/body/div/div[@class='i-dark-drill-down'][1]")
	protected WebElement radialMenuExpandBtn;

	//*[contains(@id,'Canvas')]//*[name()='svg' and @id = 'defaultID']//*[@class='i-dark-drill-down']
	@FindBy(xpath ="//div[contains(@id, 'Canvas')]//div[@class='Btn3D']/div[@class='i-dark-drill-down']") //   //*[@class='i-dark-drill-down']
	protected List<WebElement> clickDDoption;

	@FindBy(xpath = "//*[contains(@id,'currdashnametxt') and @title ='New Dashboard']")
	protected WebElement newDashBoardName;

	@FindBy(xpath = "//*[@class='openInside' and @title='Open Inside']")
	protected WebElement openOutside;

	@FindBy(xpath = "//*[@id='dashMenu']")
	protected WebElement dashMenuToReturnFocus;

	@FindBy(xpath = "//*[@title='Switch View Type']")
	protected WebElement switchViewType;

	@FindBy(xpath = "//*[@class='chartSettingBtn' and @title='View as Report']")
	protected WebElement openReportViewIcon;

	@FindBy(xpath = "//*[contains(@id,'fullSrcn_SettingIcon') and @title='Fullview']")
	protected WebElement reportFullView;

	// report area of cell to right click to open radial menu to add dimension
	@FindBy(xpath = "//*[@class='grid-canvas']/div[3]/div[2]") // (xpath = "//*[@class='ui-widget-content slick-row even']/div[2]")
	protected WebElement cellToRightClick;
	
	//report Date cell to right click to open radial menu for Timeline KPI's 
	// Also click Date Cell to make Parameter icon visible
	@FindBy(xpath = "//*[(text()='Date')]")
	protected WebElement dateColumn;
	
	// report Bucket cell to right click to open radial menu for Bucket KPi's
	@FindBy(xpath = "//*[(text()='Aging Bucket')]")
	protected WebElement bucketColumn;
	
	// report Total cell to right click to open radial menu for Bucket KPi's
	@FindBy(xpath = "//*[(text()='Total')]")
	protected List<WebElement> totalColumnList;
	
	// to check if Total cell is displayed
	@FindBy(xpath = "//*[(text()='Total')]")
	protected WebElement totalColumn;

	@FindBy(xpath = "//*[@class='i-dark-add']")
	protected WebElement addDimensionIcon;

	// @FindBy(css = ".i-dark-view")
	// WebElement expandAddDimensionBtn;

	@FindBy(xpath = "//*[@class='i-dark-view']")
	protected List<WebElement> addDimensionBtnList;

	@FindBy(xpath = "//*[@class='zc-img']")
	protected WebElement kpiArea;

	@FindBy(css = ".Scenario-InActive")
	protected WebElement showDashboardIcon;
	
	@FindBy(xpath ="//*[@id='menuListGrp_Dashboards']/div[2]")
	protected WebElement clickDashboardName;
	
	@FindBy(css =".AutoStreamOFF")
	protected WebElement streamIcon;
	
	@FindBy(xpath = "//*[text()='The server encountered an error processing the request.']")
	protected WebElement errorMessage;
	
	@FindBy(xpath = "//*[contains(@src,'images/wait.svg')]")
	protected WebElement waitImg;
	
	@FindBy(xpath = "//*[contains(@title,'Click to show the Dashboard')]")
	protected List <WebElement> listOfDashboards;
	
	@FindBy(xpath = "//*[contains(@title,'Click to show the KPI')]")
	protected List <WebElement> listOfKPIs;
	
	@FindBy(css = ".EDclosebtn")
	protected WebElement kpiCloseBtn;
	
	@FindBy(xpath = "//*[contains(@id,'graph-id0-scale_x-item_7') and @style='font-size: 11px; text-anchor: middle;']")
	protected WebElement xAxisLabel;
	
	@FindBy(xpath = "//*[@title ='Settings']")
	protected WebElement kpiSettingsIcon;
	
	@FindBy(xpath = "//*[@title ='Open Inside']")
	protected WebElement openInOutKpiBtn;
	
	@FindBy(css = ".i-d-arrow-down-black")
	protected WebElement expandDDMenuBtn;
	
	@FindBy(xpath = "//label[contains(@id,'titlelbl') and contains(@title,'by')]//parent::div//parent::div//descendant::div[@id='undefinedDCloseBtn']")
	protected WebElement ddKPICloseBtn;
	
	@FindBy(xpath = "//*[@class='dashclosebtn']")
	protected WebElement dashBoardCloseIcon;
	
	@FindBy(xpath = "//*[contains(@id,'currdashnamedv')]")
	protected WebElement dashboardName;
	
	@FindBy(xpath = "//*[contains(@id,'graph-id0-path')]")
	protected WebElement kpiContainer;
	
	@FindBy(xpath = "//*[contains(@id,'HdrCnt')]")
	protected WebElement reportHeader;
	
	@FindBy(xpath = "//*[@class='EDclosebtn']")
	protected WebElement reportCloseBtn;
	
	
	//*[@style='cursor: pointer;']//parent::*//following-sibling::*/html/body/div/div[@class='i-d-arrow-down-black']
	@FindBy(xpath = "//*[@class='i-d-arrow-down-black']")
	protected List<WebElement> addDimShowMore;
	
	@FindBy(xpath = "//*[@class='i-d-arrow-up-black']")
	protected WebElement addDimShowLess;

	@FindBy(xpath = "//*[contains(@id,'titlelbl')]")
	protected List<WebElement> kpiTitle;
	
	@FindBy(xpath = "//*[@class='Measures-InActive' and @title='Show Measures']")
	protected WebElement showMeasureIcon;
	
	@FindBy(xpath = "//*[contains(@title,'Click to show the Measure')]")
	protected List<WebElement> measureList;
	
	// report area of cell to right click to open radial menu to add first dimension as super header
	@FindBy(xpath = "//*[@class='grid-canvas']/div[3]/div[3]") // (xpath = "//*[@class='ui-widget-content slick-row even']/div[2]")
	protected WebElement cellToRightClick1;
	
	// report area of cell to right click to open radial menu to add second dimension as super header
		@FindBy(xpath = "//*[@class='grid-canvas']/div[7]/div[3]") // (xpath = "//*[@class='ui-widget-content slick-row even']/div[2]")
		protected WebElement cellToRightClick2;

	// View as Header Icon
	@FindBy(xpath = "//*[@class='i-dark-carrot-addSupHeader']")
	protected WebElement viewAsHeader;
	
	//Header button list
	@FindBy(xpath = "//*[@class='i-dark-carrot-addSupHeader']")
	protected List<WebElement> headerBtnList;
	
	//Parameter Search Icon
	@FindBy(xpath = "//*[@title='Add New Filter']")
	protected WebElement parameterIcon;
	
	//Parameter text box to eneter value to apply filter on
	@FindBy(xpath = "//*[@id='fltrvaltxt3']")
	protected WebElement parameterTextBox;
	
	//Parameter search button
	@FindBy(xpath = "//*[@id='fltrsubmitbtn3']")
	protected WebElement parameterSearchBtn;
	
	//Measure Cell to drag and drop to open Formulae
	//@FindBy(xpath = "//*[contains(@class,'slick-cell l2 r2 cellBlank') and text()='5% of Total LS Fees']")
	@FindBy(xpath = "//*[@class='ui-widget-content slick-row odd'][1]/div[3]")
	protected WebElement cellToDragDrop1;
	
	//Measure Cell to drag and drop to open Formulae
		//@FindBy(xpath = "//*[contains(@class,'slick-cell l3 r3 cellBlank') and text()='Eligible Receipts']")
	@FindBy(xpath = "//*[@class='ui-widget-content slick-row odd'][1]/div[4]")
		protected WebElement cellToDragDrop2;
		
	//Formulae Sum icon locator
		@FindBy(xpath = "//*[@class='i-dark-add']")
		protected WebElement sumIcon;
	
	//Formulae Difference icon locator
		@FindBy(xpath = "//*[@class='i-dark-subtract']")
		protected WebElement differenceIcon;

	//Formulae Difference icon locator
		@FindBy(xpath = "//*[@class='percentage']")
		protected WebElement percentageIcon;

	//Formulae Difference icon locator
		@FindBy(xpath = "//*[@class='multiple']")
		protected WebElement multipleIcon;

	//Formulae Difference icon locator
		@FindBy(xpath = "//*[@class='division']")
		protected WebElement divisionIcon;
	
}
