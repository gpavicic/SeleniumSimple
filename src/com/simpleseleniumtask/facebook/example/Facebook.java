package com.simpleseleniumtask.facebook.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Facebook {
	
	private static final Logger LOG = LoggerFactory.getLogger(Facebook.class);

	public static final String APP_LINK = "https://www.facebook.com/";
	public static final String CSS_SELECTOR = "option";
	public static final String VALUE = "value";

	public static final String FIRST_NAME = "SomeFirstName";
	public static final String LAST_NAME = "SomeLastName";
	public static final String EMAIL = "SomeEmail@SomeEmail.com";
	public static final String EMAIL_CONFIRMATION = "SomeEmail@SomeEmail.com";
	public static final String PASSWORD = "SomePassword";
	public static final String MONTH = "11";
	public static final String DAY = "15";
	public static final String YEAR = "2000";

	WebDriver driver;

	public static void invokeBrowser(WebDriver driver) {
		try {
			LOG.info(" |INFO| Launching FACEBOOK test scenario.");
			// Target web-page
			driver.get(APP_LINK);

			// Test scenario
			findByNameForGivenValue(driver, By.name("firstname"), FIRST_NAME);
			findByNameForGivenValue(driver, By.name("lastname"), LAST_NAME);
			findByNameForGivenValue(driver, By.name("reg_email__"), EMAIL);
			findByNameForGivenValue(driver, By.name("reg_email_confirmation__"), EMAIL_CONFIRMATION);
			findByNameForGivenValue(driver, By.name("reg_passwd__"), PASSWORD);

			findByIdForGivenValues(driver, By.id("month"), MONTH);
			findByIdForGivenValues(driver, By.id("day"), DAY);
			findByIdForGivenValues(driver, By.id("year"), YEAR);

			driver.findElement(By.cssSelector("span._5k_2:nth-child(1) > label:nth-child(2)")).click();
			driver.findElement(By.cssSelector("span._5k_2:nth-child(2) > label:nth-child(2)")).click();
			driver.findElement(By.xpath("//button[@name='websubmit']")).click();

		} catch (Exception e) {
			LOG.info(" |ERROR| Launching FACEBOOK test scenario.");
			e.printStackTrace();
		}
	}

	private static void findByNameForGivenValue(WebDriver driver, By name, String key) {
		driver.findElement(name).sendKeys(key);
	}

	private static void findByIdForGivenValues(WebDriver driver, By element, String key) {
		WebElement month = driver.findElement(element);
		List<WebElement> OptionsMonth = month.findElements(By.cssSelector(CSS_SELECTOR));

		for (WebElement option : OptionsMonth) {
			if (option.getAttribute(VALUE).equals(key)) {
				option.click();
				break;
			}
		}
	}

}
