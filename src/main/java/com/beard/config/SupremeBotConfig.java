package com.beard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.beard.api.SupremeBotAPI;
import com.beard.api.SupremeBotAPInterface;
import com.beard.pages.SupremeShopPage;

@Configuration
public class SupremeBotConfig {
	
	@Bean
	public SupremeBotAPInterface supremeBotAPI() {
		SupremeBotAPI supremeBotAPI = new SupremeBotAPI();
		supremeBotAPI.setSupremeShopPage(supremeShopAllPage());
		return supremeBotAPI;
	}
	
	@Bean
	public SupremeShopPage supremeShopAllPage() {
		SupremeShopPage supremeShopAllPage = new SupremeShopPage();
		return supremeShopAllPage;	
	}
	
}
