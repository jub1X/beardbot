package com.beard.api;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.pages.SupremeShopPage;

public interface SupremeBotAPInterface {

	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException;

	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException;

	public Map<String, Boolean> retrieveAllNewProductLinksWithSoldOutStatusOnTheShopAllPage(WebDriver webDriver) throws BeardRunTimeException;

	public void setSupremeShopPage(SupremeShopPage supremeShopPage);


}
