package com.beard.api;

import java.util.Map;
import org.openqa.selenium.WebDriver;

import com.beard.exceptions.BeardRunTimeException;
import com.beard.pages.SupremeShopAllPage;

public class SupremeBotAPI implements SupremeBotAPInterface {

	private SupremeShopAllPage supremeShopAllPage;

	@Override
	public Map<String, Boolean> retrieveAllNewProductLinksWithSoldOutStatus(WebDriver webDriver) throws BeardRunTimeException {
		return supremeShopAllPage.retrieveAllAvailableProductItemsAndSoldOutStatus(webDriver);
	}
	@Override
	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopAllPage.openSupremeShopAllPage(webDriver);
	}

	@Override
	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopAllPage.openSupremeShopNewPage(webDriver);
	}
	
	public void setSupremeShopAllPage(SupremeShopAllPage supremeShopAllPage) {
		this.supremeShopAllPage = supremeShopAllPage;
	}


}
