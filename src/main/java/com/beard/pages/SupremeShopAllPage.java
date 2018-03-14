package com.beard.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.locators.SupremeEntireItemsLocator;

public class SupremeShopAllPage extends SupremeEntireItemsLocator {

	private final static String SUPREME_WEBSITE = "http://www.supremenewyork.com/shop/all";
	WebDriver webDriver;

	public SupremeShopAllPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public void openSupremeShopAllPage() throws BeardRunTimeException {
		webDriver.get(SUPREME_WEBSITE);
		retrieveAllAvailableItemsAndDisplayStatus();
	}

	public void retrieveAllAvailableItemsAndDisplayStatus() throws BeardRunTimeException {
		List<WebElement> articleElementList = webDriver.findElements(By.xpath("//*[@id=\"container\"]/article"));
		String productLink = "";
		Boolean isSoldOut = true;
		for (WebElement article : articleElementList) {
			WebElement articleElement = article.findElement(By.cssSelector("div > a"));
			productLink = articleElement.getAttribute("href");
			if (isWebElementPresent(webDriver, article, By.cssSelector("div > a > div"))) {
				articleElement = article.findElement(By.cssSelector("div > a > div"));
				isSoldOut = getTextFromWebElementFromJavaScript(webDriver, articleElement).trim()
						.equalsIgnoreCase("sold out") ? true : false;
				System.out.println("Product Link : " + productLink + " is sold out!");
				if (!isSoldOut)
					throw new BeardRunTimeException("ERROR: Failed to read status code for product");
			} else {
				System.out.println("Product Link : " + productLink + " is still available");
			}

		}
	}
}
