package com.beard.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.locators.SupremeEntireItemsLocator;
import com.beard.pages.utilties.SupremeShopPageHelper;

public class SupremeShopPage extends SupremeEntireItemsLocator {

	private final static String SUPREME_WEBSITE_ALL_PRODUCTS = "http://www.supremenewyork.com/shop/all";
	private final static String SUPREME_WEBSITE_ALL_PRODUCTS_NEW = "http://www.supremenewyork.com/shop/new";

	private final static String CONTAINER_FULL_OF_ARTICLES_XPATH = "//*[@id=\"container\"]/article";
	private final static String ARTICLE_STATUS_DIV = "div > a > div";
	private final static String ARTICLE_PRODUCT_LINK_DIV = "div > a";

	private SupremeShopPageHelper supremeShopPageHelper;
	
	public void openSupremeShopAllPage(WebDriver webDriver) throws BeardRunTimeException {
		webDriver.get(SUPREME_WEBSITE_ALL_PRODUCTS);
	}

	public void openSupremeShopNewPage(WebDriver webDriver) throws BeardRunTimeException {
		webDriver.get(SUPREME_WEBSITE_ALL_PRODUCTS_NEW);
	}

	/**
	 * Retrieves all available products from supreme and returns map of product link
	 * and sold out status
	 * 
	 * @throws BeardRunTimeException
	 */
	public Map<String, Boolean> retrieveAllAvailableProductItemsAndSoldOutStatus(WebDriver webDriver) throws BeardRunTimeException {
		Map<String, Boolean> productLinkAndSoldOutStatusMap = new HashMap<String, Boolean>();
		List<WebElement> articleElementList = webDriver.findElements(By.xpath(CONTAINER_FULL_OF_ARTICLES_XPATH));
		String productLink = "";
		for (WebElement article : articleElementList) {
			WebElement articleElement = article.findElement(By.cssSelector(ARTICLE_PRODUCT_LINK_DIV));
			productLink = articleElement.getAttribute("href");
			productLinkAndSoldOutStatusMap.put(productLink, checkIfProductIsSoldOut(webDriver,productLink, articleElement));
		}
		return productLinkAndSoldOutStatusMap;
	}

	/**
	 * @param productLink
	 * @param articleWebElement
	 * @return
	 * @throws BeardRunTimeException
	 */
	public boolean checkIfProductIsSoldOut(WebDriver webDriver,String productLink, WebElement articleWebElement)
			throws BeardRunTimeException {
		if (isWebElementPresent(webDriver, articleWebElement, By.cssSelector(ARTICLE_STATUS_DIV))) {
			WebElement articleElement = articleWebElement.findElement(By.cssSelector(ARTICLE_STATUS_DIV));
			if (getTextFromWebElementFromJavaScript(webDriver, articleElement).trim().equalsIgnoreCase("sold out")) {
				System.out.println("Product Link : " + productLink + " is sold out!");
				return true;
			} else {
				throw new BeardRunTimeException("ERROR: Failed to read status code for product");
			}
		} else {
			System.out.println("Product Link : " + productLink + " is still available");
			return false;
		}
	}

	public void setSupremeShopPageHelper(SupremeShopPageHelper supremeShopPageHelper) {
		this.supremeShopPageHelper = supremeShopPageHelper;
	}
	
	
}
