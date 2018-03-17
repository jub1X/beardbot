package com.beard.api;

import java.util.List;
import org.openqa.selenium.WebDriver;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.ProductInformation;
import com.beard.pages.SupremeShopPage;

public class SupremeBotAPI implements SupremeBotAPInterface {

	private SupremeShopPage supremeShopPage;

	@Override
	public List<ProductInformation> retrieveAllNewProductLinksWithSoldOutStatusOnTheShopAllPage(WebDriver webDriver) throws BeardRunTimeException {
		return supremeShopPage.retrieveAllAvailableProductItemsAndSoldOutStatus(webDriver);
	}
	@Override
	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopPage.openSupremeShopAllPage(webDriver);
	}

	@Override
	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopPage.openSupremeShopNewPage(webDriver);
	}
	
	@Override
	public void setSupremeShopPage(SupremeShopPage supremeShopPage) {
		this.supremeShopPage = supremeShopPage;
	}
	

}
