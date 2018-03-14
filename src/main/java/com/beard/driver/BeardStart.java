package com.beard.driver;

import com.beard.exceptions.BeardRunTimeException;

public class BeardStart {
	
	public static void main(String[] args) throws BeardRunTimeException {
		BeardDriver driver = new BeardDriver();
		driver.startBot();
	}
	
}	
