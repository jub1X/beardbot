package com.beard.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.beard.api.SupremeBotAPI;
import com.beard.api.SupremeBotAPInterface;
import com.beard.config.SupremeBotConfig;
import com.beard.exceptions.BeardRunTimeException;

public class BeardStart {

	public static SupremeBotAPInterface supremeBotAPI;

	public static void main(String[] args) throws BeardRunTimeException {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SupremeBotConfig.class);
		BeardDriver beardDriver = new BeardDriver(ctx.getBean(SupremeBotAPI.class));
		beardDriver.startBot();
	}

}
