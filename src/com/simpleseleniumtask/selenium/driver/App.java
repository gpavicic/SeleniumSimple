package com.simpleseleniumtask.selenium.driver;

import org.openqa.selenium.WebDriver;

import com.simpleseleniumtask.ebay.example.Ebay;
import com.simpleseleniumtask.facebook.example.Facebook;

public class App {
	public static final String FIREFOX = "FIREFOX";
	public static final String CHROME = "CHROME";
//	public static final String OPERA = "OPERA";


	public static void main(String[] args) {
		startTesting(FIREFOX);
//		an issue with Chrome browser maximization fixed with new driver version 2.33
		startTesting(CHROME);
//		an issue with opera browser binary 
//		startTesting(OPERA);
	}
	

	private static void startTesting(String browser) {
		DriverSetup driverSetup = new DriverSetup(browser.toLowerCase());
		WebDriver driver = driverSetup.getDriver();
		Ebay.invokeBrowser(driver);
		Facebook.invokeBrowser(driver);
	}

}
