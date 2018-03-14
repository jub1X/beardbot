package com.beard.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.beard.exceptions.BeardRunTimeException;

public class PageLocators {

	public WebElement getWebElement(Locators locator,String elementIdentifier, WebDriver webDriver)
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
	
	public boolean isWebElementPresent(WebDriver webDriver,WebElement webElement,By by){
        try{
        	webElement.findElement(by);
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
	
	public String getTextFromWebElementFromJavaScript(WebDriver webDriver, WebElement webElement) {
		return (String) executeJavaScript(webDriver,"return $(arguments[0] ).text()",webElement);
	}
	
	public Object executeJavaScript(WebDriver webDriver,String script, WebElement webElement) {
		return getJavaScriptExecutor(webDriver).executeScript(script, webElement);
	}
	public JavascriptExecutor getJavaScriptExecutor(WebDriver webDriver) {
		return(JavascriptExecutor) webDriver;
	}
}
