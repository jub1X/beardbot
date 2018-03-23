package com.beard.api;

import java.util.List;
import org.openqa.selenium.WebDriver;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.ProductInformation;
import com.beard.pages.SupremeShopPageController;
import com.beard.pages.SupremeShopProductPageController;

public class SupremeBotAPI implements SupremeBotAPInterface {

	private SupremeShopPageController supremeShopPage;
	private SupremeShopProductPageController supremeShopProductPage;

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
	public void openSupremeAnyClothingProductLinkPage(WebDriver webDriver, String productlink) throws BeardRunTimeException {
		supremeShopPage.openSupremeAnyClothingProductLinkPage(webDriver, productlink);
		
	}
	@Override
	public void clickAddProductToCartFromProductPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopProductPage.clickAddToCartButtonOnProductPage(webDriver);
		
	}
	
	@Override
	public void clickCheckOutNowButtonForAnyPage(WebDriver webDriver) throws BeardRunTimeException {
		supremeShopProductPage.clickCheckOutNowButtonForAnyPage(webDriver);
	}
	@Override
	public void setSupremeShopPageController(SupremeShopPageController supremeShopPage) {
		this.supremeShopPage = supremeShopPage;
	}
	@Override
	public void setSupremeShopProductPageController(SupremeShopProductPageController supremeShopProductPage) {
		this.supremeShopProductPage = supremeShopProductPage;
	}

}
