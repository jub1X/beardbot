package com.beard.pages;

import org.openqa.selenium.WebDriver;

public class SupremeShopAllPage {
	
	private final static String SUPREME_WEBSITE = "http://www.supremenewyork.com/shop/all";
	WebDriver webDriver;

	public SupremeShopAllPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void openSupremeShopAllPage() {
		webDriver.get(SUPREME_WEBSITE);
	}
	
}
