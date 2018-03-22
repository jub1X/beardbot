package com.beard.api;

import java.util.List;
import org.openqa.selenium.WebDriver;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.ProductInformation;
import com.beard.pages.SupremeShopPageController;
import com.beard.pages.SupremeShopProductPageController;

public interface SupremeBotAPInterface {

	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException;

	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException;
	
	public void openSupremeAnyClothingProductLinkPage(WebDriver webDriver,String productlink) throws BeardRunTimeException ;
	
	public void addProductToCartFromProductPage(WebDriver webDriver);

	public List<ProductInformation> retrieveAllNewProductLinksWithSoldOutStatusOnTheShopAllPage(WebDriver webDriver) throws BeardRunTimeException;

	public void setSupremeShopPage(SupremeShopPageController supremeShopPage);

	public void setSupremeShopProductPage(SupremeShopProductPageController SupremeShopProductPage);
}
