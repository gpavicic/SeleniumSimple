package com.simpleseleniumtask.selenium.driver;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	private static final Logger LOG = LoggerFactory.getLogger(DriverSetup.class);

	public static final String DRIVER_PATH = "C:\\Selenium\\drivers\\";

	private WebDriver driver;

	public DriverSetup(String driverType) {
		setDriver(driverType);
	}

	private void setDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
//		case "opera":
//			driver = initOperaDriver();
//			break;
		default:
			LOG.info("Launching default driver.");
			driver = initFirefoxDriver();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	private static WebDriver initChromeDriver() {
		WebDriver driver = null;
		try {
			LOG.info(" |INFO| test on CHROME browser");
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver.exe");
			driver = new ChromeDriver();
			setUpDriver(driver);
		} catch (Exception e) {
			LOG.error(" |ERROR| test on CHROME browser");
			e.printStackTrace();
		}
		return driver;
	}

	private static WebDriver initFirefoxDriver() {
		WebDriver driver = null;
		try {
			LOG.info(" |INFO| test on FIREFOX browser");
			System.setProperty("webdriver.gecko.driver", DRIVER_PATH + "geckodriver.exe");
			driver = new FirefoxDriver();
			setUpDriver(driver);
		} catch (Exception e) {
			LOG.error(" |ERROR| test on FIREFOX browser");
			e.printStackTrace();
		}
		return driver;
	}
	
//	private static WebDriver initOperaDriver() {
//		WebDriver driver = null;
//		try {
//			LOG.info(" |INFO| test on OPERA browser");
////			System.setProperty("webdriver.opera.driver", DRIVER_PATH + "operadriver.exe");
//			System.setProperty("webdriver.opera.driver", "C:\\Program Files\\Opera\\49.0.2725.47\\opera.exe");
//			driver = new OperaDriver();
//			setUpDriver(driver);
//		} catch (Exception e) {
//			LOG.error(" |ERROR| test on OPERA browser");
//			e.printStackTrace();
//		}
//		return driver;
//	}

	private static void setUpDriver(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}


}
