package com.qa.step_definition;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase 
{
	public Properties prop;
	public Properties credProp;

	public static WebDriver driver;

	public void init(){
		prop = new Properties();
		credProp = new Properties();
		try {
			FileInputStream ip1 = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			prop.load(ip1);
			FileInputStream ip2 = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/credentials.properties");
			credProp.load(ip2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
