package com.beard.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.beard.api.SupremeBotAPI;
import com.beard.api.SupremeBotAPInterface;
import com.beard.pages.SupremeShopPage;

@Configuration
@Import(SupremeBotHelperConfig.class)
public class SupremeBotConfig {
	
	@Autowired
	SupremeBotHelperConfig supremeBotHelperConfig;
	@Bean
	public SupremeBotAPInterface supremeBotAPI() {
		SupremeBotAPI supremeBotAPI = new SupremeBotAPI();
		supremeBotAPI.setSupremeShopPage(supremeShopAllPage());
		return supremeBotAPI;
	}
	
	@Bean
	public SupremeShopPage supremeShopAllPage() {
		SupremeShopPage supremeShopAllPage = new SupremeShopPage();
		supremeShopAllPage.setSupremeShopPageHelper(supremeBotHelperConfig.supremeShopPageHelper());
		return supremeShopAllPage;	
	}
	
}
