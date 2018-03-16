package com.beard.api;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import com.beard.driver.ChromeBotWebDriver;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.pages.SupremeShopAllPage;

public interface SupremeBotAPInterface {

	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException;

	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException;

	public Map<String, Boolean> retrieveAllNewProductLinksWithSoldOutStatus(WebDriver webDriver) throws BeardRunTimeException;

	public void setSupremeShopAllPage(SupremeShopAllPage supremeShopAllPage);

}
