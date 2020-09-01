package com.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil extends TestBase {

	static int PAGE_LOAD_TIMEOUT = 50;
	static int IMPLICIT_WAIT = 10;

	// All the commonly used items like wait, page load timeout and methods will be
	// defined here

//	public static void captureScreenshot(WebDriver driver, String screenshotName) {
//		try {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File source = ts.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));
////			FileHandler.copy(source, new File("./Screenshots/" + screenshotName + ".png"));
//		}
//
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Exception while taking screenshot" + e.getMessage());
//		}
//
//	}

}
