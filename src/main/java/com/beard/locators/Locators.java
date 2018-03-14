package com.beard.locators;

public enum Locators {
	
	CSS("cssselector"), 
	ID("id"), 
	NAME("name"), 
	LINK_TEXT("linktext"),
	TAG_NAME("tagname"),
	XPATH("xpath"),
	CLASS_NAME("classname");
	
	private String selectorName;

	Locators(String selectorName) {
		this.selectorName = selectorName;
	}

	public String getSelectorName() {
		return selectorName;
	}
	

}
