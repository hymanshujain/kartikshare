package com.qa.pageHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.HomePage;

public class Home_PageHelper extends HomePage {

	public Home_PageHelper(WebDriver driver) {
		super(driver);

	}

	public boolean verifyNewDashIcon() {
		return newDashboardIcon.isDisplayed();

	}

	public boolean verifyDashSettingsIcon() {
		return dashSettings.isDisplayed();
	}

	public void openKpiMenu() throws Exception {

			Thread.sleep(4000);
			try {
		if (obj.kpiMenuON.isDisplayed()) {
			System.out.println("--- KPI Menu Open Success ---");
		}
			}
			catch (Exception e) {

			if (obj.kpiMenuOff.isDisplayed()) {
				obj.kpiMenuOff.click();
				System.out.println("--- KPI Menu Open Success_Second Attempt ---");
			}
		}
		}

	public void findKPIAndOpen(String KpiName) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@itemname='" + KpiName + "']")).click();
	}

	public void findKpiAreaAndRightClickToOpenRadialMenuAndThenDD(int n) throws InterruptedException {
		Actions action = new Actions(driver);

		// find the KPI area and right click on it to open Radial menu
        action.moveToElement(obj.kpiArea).build().perform();
		WebElement rightClickElement = obj.xAxisLabel;
		action.contextClick(rightClickElement).build().perform();
		// Expand radial menu
		Thread.sleep(8000);
		radialMenuExpandBtn.click();
		// Click on DD option
		List<WebElement> ddList = clickDDoption;

		WebElement ddoption = ddList.get(n);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ddoption);
		obj.waitToLoad();
		//obj.extractJSLogsInfo();

	}

	public void verifyKpiIsOpen() {
		swapAxisIcon.isDisplayed();

	}

	public boolean checkIfNewDashboardPresent() {
		if (newDashBoardName.isDisplayed()) {
			System.out.println("True");
			return true;

		} else {
			System.out.println("True");
			return false;

		}

	}

	public void openNewDashboard() {
		obj.newDashboardIcon.click();

	}

	public void clickOpenOutSide() {
		obj.openOutside.click();
	}

	public void clickDashSettings() {
		obj.dashSettings.click();
	}

	public void clickDashMenuToReturnFocus() {
		obj.dashMenuToReturnFocus.click();
	}

	public void openReportViewFromKpi() throws InterruptedException {
		// mouse hover over KPI area to make Switch View Type Icon visible
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		builder.moveToElement(obj.kpiArea).build().perform();
		// mouse hover on Switch view type Icon
		builder.moveToElement(obj.switchViewType).build().perform();
		Thread.sleep(2000);
		obj.openReportViewIcon.click();
		builder.moveToElement(obj.kpiArea).build().perform();
		obj.kpiCloseBtn.click();
		obj.reportFullView.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,-1000)");
		
//		List<WebElement> webElement = driver.findElements(By.xpath("//*[contains(@id,'KPI_')]"));
		
//		EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
//		eventFiringWebDriver.executeScript("document.getElementByID('webElement.get(0)').scrollTop = 500");
//		builder.moveToElement(webElement.get(0)).build().perform();
//		webElement.get(0).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
	}

	public void AddDimension() throws InterruptedException {

//		Thread.sleep(2000);
//		Actions action = new Actions(driver);
//		// find the cell and right click on it to open Radial menu
//		WebElement rightClickElement = cellToRightClick;
//		action.contextClick(rightClickElement).build().perform();
//		Thread.sleep(1000);
//		addDimensionIcon.click();
		
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		// find the cell and right click on it to open Radial menu
		if (obj.dateColumn.isDisplayed()) {
		WebElement rightClickElement = obj.dateColumn;
		action.contextClick(rightClickElement).build().perform();
		}else if (obj.bucketColumn.isDisplayed()) {
		WebElement rightClickElement = obj.bucketColumn;
		action.contextClick(rightClickElement).build().perform();	
		}else if (obj.totalColumn.isDisplayed()) {			
		WebElement rightClickElement = obj.totalColumnList.get(0);
		action.contextClick(rightClickElement).build().perform();		
		}		
		Thread.sleep(1000);
		addDimensionIcon.click();

		for (int i = 0; i < addDimensionBtnList.size(); i++) {
			List<WebElement> ddList = addDimensionBtnList; 

			WebElement expandDimesion = ddList.get(0);
			Thread.sleep(2000);
			expandDimesion.click();
			Thread.sleep(1000);
			WebElement addDim1 = ddList.get(i);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", addDim1);
			obj.extractJSLogsInfo();
			obj.waitToLoad();
		}

	}

	public void openDashboard() throws InterruptedException {

		showDashboardIcon.click();
		Thread.sleep(2000);
		clickDashboardName.click();
		Thread.sleep(5000);

		logJavaScriptConsoleError();

		// if(errorMessage.isDisplayed()) {
		// System.out.println("Test fail KPI/Report doesnt open on Dashboard");
		// //include the dashboard name also to identify which dashboard failed
		// }

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(swapAxisIcon),
				ExpectedConditions.visibilityOf(streamIcon)));

	}

	// Method to open all KPI's
	public void open_All_KPI_s() throws InterruptedException {

		// List<WebElement> elements =
		// driver.findElements(By.xpath("//*[contains(@title,'Click to show the
		// KPI')]"));
		java.util.Iterator<WebElement> i = obj.listOfKPIs.iterator();
		while (i.hasNext()) {

			WebElement element = i.next();
			if (element.isDisplayed()) {
				element.click();
				obj.extractJSLogsInfo();
				obj.waitToLoad();
				try {
					if (obj.kpiContainer.isDisplayed()) {
						Actions action = new Actions(driver);
						action.moveToElement(obj.kpiAreaToRightClick).build().perform();
						obj.kpiCloseBtn.click();
						logJavaScriptConsoleError();
					} else if (obj.reportHeader.isDisplayed()) {

						// WebElement reportCloseBtn =
						// driver.findElement(By.xpath("//*[@class='EDclosebtn']"));
						// Thread.sleep(2000);
						// reportCloseBtn.click();

					} else {
						driver.close();
					}

				} catch (NoSuchElementException e) {
					System.out.println("Element not present");
					// WebElement reportCloseBtn =
					// driver.findElement(By.xpath("//*[@class='EDclosebtn']"));
					Thread.sleep(2000);
					obj.reportCloseBtn.click();
				}

			}
		}
	}

	// Open All the Dashboards
	public void open_all_the_dashboards() throws InterruptedException {

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(8000);
		obj.showDashboardIcon.click();
		Thread.sleep(2000);
		// List <WebElement> elements =
		// driver.findElements(By.xpath("//*[contains(@title,'Click to show the
		// Dashboard')]"));
		java.util.Iterator<WebElement> i = obj.listOfDashboards.iterator();
		while (i.hasNext()) {
			WebElement element = i.next();
			if (element.isDisplayed()) {
				element.click();
				Thread.sleep(2000);
				logJavaScriptConsoleError();
				obj.extractJSLogsInfo();
				obj.waitToLoad();
				Actions action = new Actions(driver);
				action.moveToElement(obj.dashboardName).build().perform();
				obj.dashBoardCloseIcon.click();

			}

		}
	}

	// Method to capture console error if any and fail the testcase/scenario if
	// found any JS error

	public void extractJSLogsInfo() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Calendar calobj = Calendar.getInstance();
			System.out.println(df.format(calobj.getTime()) + " " + " " + entry.getLevel() + " " + entry.getMessage());
			Assert.fail("-----------Fail with Js Error ----------" + entry.getMessage());

		}
	}

	// This method is not used anywhere need to remove it ------
	void logJavaScriptConsoleError() {
		Logs logs = driver.manage().logs();
		LogEntries logEntries = logs.get(LogType.BROWSER);
		for (LogEntry logEntry : logEntries) {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println("Console log found in Test- " + methodName);
			System.out.println("__________________________________________________________");
			if (logEntry.getMessage().toLowerCase().contains("Error")) {
				System.out.println("Error Message in Console:" + logEntry.getMessage());
				Assert.fail();
			} else if (logEntry.getMessage().toLowerCase().contains("Failed to load resource)")) { // Uncaught
																									// SyntaxError
				Assert.fail();
				System.out.println("Error Message in Console:" + logEntry.getMessage());
			} else {
				System.out.println("Information Message in Console:" + logEntry.getMessage());

			}
		}

	}

	public void ddByAllOptionsOnKPI() throws InterruptedException {
		Actions builder = new Actions(driver);
		Thread.sleep(10000);
		// find the KPI area and right click on x-axis to open Radial menu
		builder.moveToElement(obj.kpiArea).build().perform();
		builder.moveToElement(obj.kpiSettingsIcon).build().perform();
		Thread.sleep(2000);
		obj.openInOutKpiBtn.click();
		WebElement rightClickElement1 = obj.xAxisLabel;
		builder.contextClick(rightClickElement1).build().perform();
		// Expand radial menu
		Thread.sleep(2000);
		obj.radialMenuExpandBtn.click();

		// get the DD options in a list
		List<WebElement> list = obj.clickDDoption;
		int count = list.size();
		for (int i = 0; i < count; i++) {

			List<WebElement> list1 = obj.clickDDoption;
			if (i != 0) {
				builder.contextClick(rightClickElement1).build().perform();
				Thread.sleep(2000);
				// Expand radial menu
				obj.radialMenuExpandBtn.click();
				Thread.sleep(2000);
			}
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", list1.get(i));
			Thread.sleep(2000);
//			obj.extractJSLogsInfo();
			obj.waitToLoad();
			logJavaScriptConsoleError();
			js.executeScript("arguments[0].click();", obj.ddKPICloseBtn);
		}

	}
	
	public void rightClickOnReportToOpenRadialMenu() {
		WebElement rightClickElement;
		Actions action = new Actions(driver);
		if (obj.dateColumn.isDisplayed()) {
		rightClickElement = obj.dateColumn;
		action.contextClick(rightClickElement).build().perform();
		}else if (obj.bucketColumn.isDisplayed()) {
		rightClickElement = obj.bucketColumn;
		action.contextClick(rightClickElement).build().perform();	
		}else if (obj.totalColumn.isDisplayed()) {			
		rightClickElement = obj.totalColumnList.get(0);
		action.contextClick(rightClickElement).build().perform();
	}
	}
	public void addAllDimensionsOnReport() throws InterruptedException {
		Thread.sleep(1000);
		Actions action = new Actions(driver);

		List<WebElement> expandedList;

		Thread.sleep(2000);

		obj.rightClickOnReportToOpenRadialMenu();
	
//		// find the cell and right click on it to open Radial menu

		Thread.sleep(1000);

		List<WebElement> addDimList = obj.addDimensionBtnList;
		WebElement expandDimension = addDimList.get(0);
		Thread.sleep(2000);
		obj.addDimensionIcon.click();
		Thread.sleep(2000);
		expandDimension.click();
		Thread.sleep(2000);
		if (obj.addDimShowMore.size() == 2) {
			obj.addDimShowMore.get(1).click();
		} else {
			obj.addDimShowMore.get(0).click();
		}

		expandedList = obj.addDimensionBtnList;
		int count = expandedList.size();
		Thread.sleep(3000);

		// To avoid Zoom out problem re-wrote the code to open add dimension radial menu
		WebElement clickOutside = driver.findElement(By.xpath("//*[contains(@id,'HdrCnt')]"));
		action.contextClick(clickOutside).build().perform();

		obj.rightClickOnReportToOpenRadialMenu();	
		Thread.sleep(1000);
		List<WebElement> addDimList2 = obj.addDimensionBtnList;
		WebElement expandDimension2 = addDimList2.get(0);
		Thread.sleep(2000);
		obj.addDimensionIcon.click();
		Thread.sleep(2000);
		expandDimension2.click();

		for (int i = 0; i < count; i++) {
			Thread.sleep(3000);

			List<WebElement> addDimList1 = obj.addDimensionBtnList; 

			Thread.sleep(2000);
			if (i != 0) {
				obj.rightClickOnReportToOpenRadialMenu();
				Thread.sleep(1000);
				obj.addDimensionIcon.click();
				WebElement expandDimension1 = addDimList1.get(0);
				Thread.sleep(2000);
				expandDimension1.click();
				Thread.sleep(1000);
			}
			WebElement addDim1 = addDimList1.get(0);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", addDim1);
//			obj.extractJSLogsInfo();
			obj.waitToLoad();			

		}

	}

	// public void zoomOut() {
	//// for(int j=0;j<3;j++) {
	//// WebElement zoomOut = driver.findElement(By.cssSelector("body"));
	//// zoomOut.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
	//// }
	// JavascriptExecutor executor = (JavascriptExecutor)driver;
	// executor.executeScript("document.body.style.zoom = '0.80'");
	// }

	// public void zoomIn() {
	//// for(int j=0;j<3;j++) {
	//// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.ADD);
	//// }
	// JavascriptExecutor executor = (JavascriptExecutor)driver;
	// executor.executeScript("document.body.style.zoom = '1.0'");
	// }
	public void openReportAddDim() throws InterruptedException {

		java.util.Iterator<WebElement> i = obj.listOfKPIs.iterator();
		while (i.hasNext()) {

			WebElement element = i.next();
			if (element.isDisplayed()) {
				element.click();
				Thread.sleep(2000);
				try {
					System.out.println("KPI Name is ++++" + obj.kpiTitle.get(0).getText() + "++++");
					obj.waitToLoad();
					obj.openReportViewFromKpi();
					obj.addAllDimensionsOnReport();
					obj.reportCloseBtn.click();
				} catch (IndexOutOfBoundsException e) {
					obj.waitToLoad();
					obj.openReportViewFromKpi();
					obj.addAllDimensionsOnReport();
					obj.reportCloseBtn.click();

				}

			}
		}
	}

	public void OpenKPI() throws InterruptedException {
		obj.openNewDashboard();
		obj.listOfKPIs.get(4).click();
		obj.waitToLoad();
		System.out.println("KPI Name is ++++" + obj.kpiTitle.get(0).getText() + "++++");
		obj.extractJSLogsInfo();

	}

	public void addMeasure() {
		obj.showMeasureIcon.click();
		obj.measureList.get(3).click();
		Actions action = new Actions(driver);
		WebElement clickKpiArea = kpiAreaToRightClick;
		action.click(clickKpiArea).build().perform();
		obj.waitToLoad();
		obj.extractJSLogsInfo();

	}

	public void waitToLoad() {
		WebDriverWait waitForLocatorToDissappear = new WebDriverWait(driver, 80);
		waitForLocatorToDissappear.until(
				ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(@src,'images/wait.svg')]")));
//			ExpectedConditions.invisibilityOf((WebElement) By.xpath("//*[contains(@src,'images/wait.svg')]")));
	}

	public void setDimAsSuperHeader() throws InterruptedException {
		Actions action = new Actions(driver);
		WebElement rightClickElement = obj.cellToRightClick1;
		action.contextClick(rightClickElement).build().perform();
		Thread.sleep(1000);
		obj.viewAsHeader.click();
		WebElement rightClickElement1 = obj.cellToRightClick2;
		action.contextClick(rightClickElement1).build().perform();
		Thread.sleep(1000);
		obj.viewAsHeader.click();
		WebElement rightClickElement2 = obj.cellToRightClick2;
		action.contextClick(rightClickElement2).build().perform();
		Thread.sleep(1000);
		obj.headerBtnList.get(1).click();
		obj.extractJSLogsInfo();
	}
	
	public void clickParaMeterSearchIcon () {
		Actions action = new Actions(driver);
		// find the KPI area and right click on it to open Radial menu
        action.moveToElement(obj.dateColumn).build().perform();
		obj.parameterIcon.click();
	}
	
	public void selectPrarmeterSearchValue () {
		Select paraMeterIcon = new Select(driver.findElement(By.xpath("//*[@id='fltrdimstxt3']")));
		paraMeterIcon.selectByIndex(2);
		
	}
	
	public void enterParameterFilterValue () {
		obj.parameterTextBox.sendKeys("vinodh");
		obj.parameterSearchBtn.click();
		obj.waitToLoad();
		obj.extractJSLogsInfo();
		
	}
	
	public void applyFormulae() throws InterruptedException {
		Actions action = new Actions(driver);
		
		ArrayList<WebElement> list = new ArrayList<WebElement>();
		
		list.add(obj.sumIcon);
		list.add(obj.differenceIcon);
		list.add(obj.multipleIcon);
		list.add(obj.percentageIcon);
		list.add(obj.divisionIcon);
		
		for (int i = 0; i<list.size(); i++) {
		Action dragAndDrop = action.clickAndHold(obj.cellToDragDrop1)
				 .moveToElement(obj.cellToDragDrop2)			 
			     .release(obj.cellToDragDrop2)			 
			    .build();			 
			   dragAndDrop.perform();
		Thread.sleep(1000);
		list.get(i).click();
		Thread.sleep(500);

		obj.extractJSLogsInfo();		
		
	}
	}

}
