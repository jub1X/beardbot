package com.beard.locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.LocatorsType;

public class PageLocators {

	public String checkOutButtonElementCSS = "#cart > a.button.checkout";
	public String addCartButtonXpath = "//*[@id=\"add-remove-buttons\"]/input";
	public String removeCartButtonXpath = "//*[@id=\"cart-remove\"]/fieldset[1]/b";
	

	public WebElement getWebElement(LocatorsType locator, String elementIdentifier, WebDriver webDriver)
			throws BeardRunTimeException {
		WebElement webElement = null;
		switch (locator) {
		case CSS:
			webElement = webDriver.findElement(By.cssSelector(elementIdentifier));
			break;
		case CLASS_NAME:
			webElement = webDriver.findElement(By.className(elementIdentifier));
			break;
		case ID:
			webElement = webDriver.findElement(By.id(elementIdentifier));
			break;
		case LINK_TEXT:
			webElement = webDriver.findElement(By.linkText(elementIdentifier));
			break;
		case NAME:
			webElement = webDriver.findElement(By.name(elementIdentifier));
			break;
		case TAG_NAME:
			webElement = webDriver.findElement(By.tagName(elementIdentifier));
			break;
		case XPATH:
			webElement = webDriver.findElement(By.xpath(elementIdentifier));
			break;
		default:
			throw new BeardRunTimeException("ERROR: Failed to find locator for " + locator.toString());
		}
		return webElement;
	}

	
	public boolean checkIfProductAddedToCartFromProductPage(WebDriver webDriver) {
		pause(500);
		return isSubWebElementPresent(webDriver, webDriver.findElement(By.xpath(removeCartButtonXpath)),
				By.xpath(removeCartButtonXpath));
	}

	public void clickCheckOutNowButtonForAnyPage(WebDriver webDriver) throws BeardRunTimeException {
		try {
			executeJavaScriptClick(webDriver, "arguments[0].click();",
					webDriver.findElement(By.cssSelector(checkOutButtonElementCSS)));
		} catch (ElementNotVisibleException e) {
			throw new BeardRunTimeException(e + " " + checkOutButtonElementCSS);
		}
	}

	public void clickAddToCartButtonOnProductPage(WebDriver webDriver) throws BeardRunTimeException {
		try {
			if(isWebElementPresent(webDriver,"//*[@id=\"cctrl\"]/form/fieldset[2]/b")) {
				System.out.println("INFO : This product is limited to 1 style per product...skipping");
				return;
			}
			webDriver.findElement(By.xpath(addCartButtonXpath)).click();
			checkIfProductAddedToCartFromProductPage(webDriver);
		} catch (ElementNotVisibleException e) {
			throw new BeardRunTimeException(e + " " + addCartButtonXpath);
		}
	}
	
	public boolean isWebElementPresent(WebDriver webDriver, String locatorString) {
		return webDriver.findElements(By.xpath(locatorString)).size() != 0;
	}

	public boolean isSubWebElementPresent(WebDriver webDriver, WebElement webElement, By by) {
		try {
			webElement.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void waitForElementToLoadForDisplayed(WebDriver webDriver, final WebElement elementIdentifier,
			long timeOutInSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
				.withTimeout(timeOutInSeconds, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS)
				.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver webDriver) {
				return (elementIdentifier != null);

			}
		});

	}

	
	public void pause(long timeOutInMillis) {
		try {
			Thread.sleep(timeOutInMillis);
		} catch (InterruptedException e) {

		}
	}

	public String getTextFromWebElementFromJavaScript(WebDriver webDriver, WebElement webElement) {
		return (String) executeJavaScript(webDriver, "return $(arguments[0] ).text()", webElement);
	}

	public Object executeJavaScript(WebDriver webDriver, String script, WebElement webElement) {
		return getJavaScriptExecutor(webDriver).executeScript(script, webElement);
	}

	public Object executeJavaScriptClick(WebDriver webDriver, String script, WebElement webElement) {
		return getJavaScriptExecutor(webDriver).executeScript(script, webElement);
	}

	public JavascriptExecutor getJavaScriptExecutor(WebDriver webDriver) {
		return (JavascriptExecutor) webDriver;
	}
}
