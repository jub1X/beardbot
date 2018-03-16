package com.beard.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBotWebDriver {
	
	private final static String CHROME_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
	
	public WebDriver createNewChromeWebDriver() {
		return new ChromeDriver(setupChromeDriverOptions());
	}
	private ChromeOptions setupChromeDriverOptions() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("test-type");
		chromeOptions.addArguments("start-maximized");
		chromeOptions.addArguments("--js-flags=--expose-gc");
		chromeOptions.addArguments("--enable-precise-memory-info");
		chromeOptions.addArguments("--disable-popup-blocking");
		chromeOptions.addArguments("--disable-default-apps");
		chromeOptions.addArguments("test-type=browser");
		chromeOptions.addArguments("disable-infobars");
		return chromeOptions;
	}
}
