package com.beard.config;

import org.springframework.context.annotation.Configuration;

import com.beard.pages.utilties.SupremeShopPageHelper;

@Configuration
public class SupremeBotHelperConfig {
	
	public SupremeShopPageHelper supremeShopPageHelper() {
		return new SupremeShopPageHelper();
	}
	
}
