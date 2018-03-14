package com.beard.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.beard.exceptions.BeardRunTimeException;
import com.beard.pages.SupremeShopAllPage;

public class BeardDriver {

	private final static String CHROME_DRIVER_PATH = "src\\main\\resources\\chromedriver.exe";
	
	private SupremeShopAllPage supremeShopAllPage;
	
	public void startBot() throws BeardRunTimeException {
		WebDriver webDriver = setupDriver();
		startSupremeBot(webDriver);
	}
	
	public void startSupremeBot(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopAllPage = new SupremeShopAllPage(webDriver);
		supremeShopAllPage.openSupremeShopAllPage();
		supremeShopAllPage.openSupremeShopNewPage();
	}

	public WebDriver setupDriver() {
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
		WebDriver webDriver = new ChromeDriver(chromeOptions);
		return webDriver;
	}

}
