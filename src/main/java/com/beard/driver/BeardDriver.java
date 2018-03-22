package com.beard.driver;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Controller;
import com.beard.api.SupremeBotAPInterface;
import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.ClothingType;
import com.beard.model.ProductInformation;

@Controller
public class BeardDriver {

	SupremeBotAPInterface supremeBotAPI;

	public BeardDriver(SupremeBotAPInterface supremeBotAPI) {
		this.supremeBotAPI = supremeBotAPI;
	}

	public void startBot() throws BeardRunTimeException {
		ChromeBotWebDriver chromeBotWebDriver = new ChromeBotWebDriver();
		WebDriver webDriver = chromeBotWebDriver.createNewChromeWebDriver();
		supremeBotAPI.openSupremeShopAllPage(webDriver);
		List<ProductInformation> productInformationList = supremeBotAPI
				.retrieveAllNewProductLinksWithSoldOutStatusOnTheShopAllPage(webDriver);
		List<ProductInformation> accessoriesList =productInformationList.stream()
				.filter(productInformation -> ClothingType.ACCESSORIES == productInformation.getClothingType())
				.collect(Collectors.toList());
		accessoriesList.stream()
		.forEach(ProductInformation -> System.out.println(ProductInformation.toString()));
		for(ProductInformation product : accessoriesList) {
			if(!product.getIsSoldOut()) {
				supremeBotAPI.openSupremeAnyClothingProductLinkPage(webDriver, product.getProductLink());
			break;
			}
		}
		//webDriver.close();
	}
}
