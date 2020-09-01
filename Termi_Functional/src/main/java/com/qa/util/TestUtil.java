package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;


public class TestUtil
{
	//public static Properties prop;
	
	//----------------------------------------------------------------------------
	//Initialize webdriver for UI Tests
	//----------------------------------------------------------------------------
	static WebDriver driver;
	enum DriverType 
	{ Firefox, IE, Chrome }
	public final static int RESPONSE_CODE_200 = 200;
	public final static int RESPONSE_CODE_201 = 201;
	public final static int RESPONSE_CODE_400 = 400;
	public final static int RESPONSE_CODE_401 = 401;
	public final static String WeatherSheetName = "WeatherInfo";
	public final static String TermiAPIDemoSheetName = "TermiAPI";
	//------------------------------------------------------------------------


	
	//----------------------------------------------------------------------------
	//Initialize and implement Method to read data from excel
	//----------------------------------------------------------------------------
	static Workbook book;
	static Sheet sheet;

	public static String APITESTDATA_SHEET_PATH = System.getProperty("user.dir")+"/src/main/java/com/qa/testdata/APITestData.xlsx";
	public static String UITESTDATA_SHEET_PATH = "./src/main/java/com/qa/testdata/UITestData.xlsx";
	
	//----------------------------------------------------------------------------
	//get body Data
	//----------------------------------------------------------------------------
	public static String getMsgBody(String msg, String activityID)
	{
		
		String str="{ type: \"message\", text: \""+msg+"\",from: {\"id\":\"akhanduri@helm360.com\"}, locale: \"en-US\",  textFormat: \"plain\",  timestamp: \""+LocalDateTime.now().toString()+"\",  channelData: {\"clientActivityId\":\""+activityID+"\"}, entities: [{type:\"ClientCapabilities\",requiresBotState:true,supportsTts:true,supportsListening:true}] }";
		return str;
	}
	
	
	//----------------------------------------------------------------------------
	//get data from excel
	//----------------------------------------------------------------------------
	public static Object[][] getAPIDataFromSheet(String sheetName){
		FileInputStream file = null;
		try {
			file = new FileInputStream(APITESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	//----------------------------------------------------------------------------
		//get data from excel
		//----------------------------------------------------------------------------
		public static Object[][] getUIDataFromSheet(String sheetName){
			FileInputStream file = null;
			try {
				file = new FileInputStream(UITESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
				}
			}
			return data;
		}


	
	//----------------------------------------------------------------------------
	//Get absolute path
	//----------------------------------------------------------------------------
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("/", "//");		
		return path;
	}


}
