package com.beard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.beard.api.SupremeBotAPI;
import com.beard.api.SupremeBotAPInterface;
import com.beard.pages.SupremeShopPageController;
import com.beard.pages.SupremeShopProductPageController;

@Configuration
@Import(SupremeBotHelperConfig.class)
public class SupremeBotConfig {
	
	@Autowired
	SupremeBotHelperConfig supremeBotHelperConfig;
	@Bean
	public SupremeBotAPInterface supremeBotAPI() {
		SupremeBotAPI supremeBotAPI = new SupremeBotAPI();
		supremeBotAPI.setSupremeShopPageController(supremeShopAllPageController());
		supremeBotAPI.setSupremeShopProductPageController(supremeShopProductPageController());
		return supremeBotAPI;
	}
	
	@Bean
	public SupremeShopPageController supremeShopAllPageController() {
		SupremeShopPageController supremeShopAllPage = new SupremeShopPageController();
		supremeShopAllPage.setSupremeShopPageHelper(supremeBotHelperConfig.supremeShopPageHelper());
		return supremeShopAllPage;	
	}
	
	@Bean
	public SupremeShopProductPageController supremeShopProductPageController() {
		SupremeShopProductPageController supremeProductPage = new SupremeShopProductPageController();
		return supremeProductPage;	
	}
}
