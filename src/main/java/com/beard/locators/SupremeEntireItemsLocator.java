package com.beard.locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SupremeEntireItemsLocator extends PageLocators {
	@FindBy(id = "container")
	public List<WebElement> allItemsElementList;
}
