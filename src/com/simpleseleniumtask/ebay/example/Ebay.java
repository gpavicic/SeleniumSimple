package com.simpleseleniumtask.ebay.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ebay {
	private static final Logger LOG = LoggerFactory.getLogger(Ebay.class);

	public static final String APP_LINK = "https://www.ebay.com/";

	WebDriver driver;
	
	public static void invokeBrowser(WebDriver driver) {
		try {
			LOG.info(" |INFO| Launching E-BAY test scenario.");
			// Target web-page
			driver.get(APP_LINK);
			
			// Test scenario
			driver.findElement(By.id("gh-ac")).sendKeys("Toys");
			driver.findElement(By.id("gh-btn")).click();
			driver.navigate().back();
			
		} catch (Exception e) {
			LOG.error("|ERROR| Launching E-BAY test scenario.");
			e.printStackTrace();
		}

	}
}
