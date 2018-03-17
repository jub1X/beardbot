package com.beard.driver;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Controller;
import com.beard.api.SupremeBotAPInterface;
import com.beard.exceptions.BeardRunTimeException;

@Controller
public class BeardDriver {

	SupremeBotAPInterface supremeBotAPI;

	public BeardDriver(SupremeBotAPInterface supremeBotAPI) {
		this.supremeBotAPI = supremeBotAPI;
	}

	public void startBot() throws BeardRunTimeException {
		ChromeBotWebDriver chromeBotWebDriver = new ChromeBotWebDriver();
		WebDriver webDriver = chromeBotWebDriver.createNewChromeWebDriver();
		supremeBotAPI.openSupremeShopNewPage(webDriver);
		supremeBotAPI.retrieveAllNewProductLinksWithSoldOutStatusOnTheShopAllPage(webDriver).stream()
				.forEach(ProductInformation -> System.out.println(ProductInformation.toString()));
		webDriver.close();
	}
}
