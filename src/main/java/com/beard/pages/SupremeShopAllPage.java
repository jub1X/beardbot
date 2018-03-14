package com.beard.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.locators.SupremeEntireItemsLocator;

public class SupremeShopAllPage extends SupremeEntireItemsLocator  {

	private final static String SUPREME_WEBSITE_ALL_PRODUCTS = "http://www.supremenewyork.com/shop/all";
	private final static String SUPREME_WEBSITE_ALL_PRODUCTS_NEW ="http://www.supremenewyork.com/shop/new";
	
	private final static String CONTAINER_FULL_OF_ARTICLES_XPATH = "//*[@id=\"container\"]/article";
	private final static String ARTICLE_STATUS_DIV = "div > a > div";
	private final static String ARTICLE_PRODUCT_LINK_DIV = "div > a";

	private WebDriver webDriver;
	
	public SupremeShopAllPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void openSupremeShopAllPage() throws BeardRunTimeException {
		webDriver.get(SUPREME_WEBSITE_ALL_PRODUCTS);
		retrieveAllAvailableProductItemsAndSoldOutStatus();
	}
	
	public void openSupremeShopNewPage() throws BeardRunTimeException {
		webDriver.get(SUPREME_WEBSITE_ALL_PRODUCTS_NEW);
		retrieveAllAvailableProductItemsAndSoldOutStatus();
	}

	/**
	 * Retrieves all availble products from supreme and returns map of product link
	 * and sold out status
	 * 
	 * @throws BeardRunTimeException
	 */
	public Map<String, Boolean> retrieveAllAvailableProductItemsAndSoldOutStatus() throws BeardRunTimeException {
		Map<String, Boolean> productLinkAndSoldOutStatusMap = new HashMap<String, Boolean>();
		List<WebElement> articleElementList = webDriver.findElements(By.xpath(CONTAINER_FULL_OF_ARTICLES_XPATH));
		String productLink = "";
		for (WebElement article : articleElementList) {
			Boolean isSoldOut = false;
			WebElement articleElement = article.findElement(By.cssSelector(ARTICLE_PRODUCT_LINK_DIV));
			productLink = articleElement.getAttribute("href");
			if (isWebElementPresent(webDriver, article, By.cssSelector(ARTICLE_STATUS_DIV))) {
				articleElement = article.findElement(By.cssSelector(ARTICLE_STATUS_DIV));
				if (getTextFromWebElementFromJavaScript(webDriver, articleElement).trim().equalsIgnoreCase("sold out"))
					System.out.println("Product Link : " + productLink + " is sold out!");
				else
					throw new BeardRunTimeException("ERROR: Failed to read status code for product");
				isSoldOut = true;
			} else {
				System.out.println("Product Link : " + productLink + " is still available");
			}
			productLinkAndSoldOutStatusMap.put(productLink, isSoldOut);
		}
		return productLinkAndSoldOutStatusMap;
	}
}
