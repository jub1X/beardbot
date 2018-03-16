package com.beard.model;

public enum LocatorsType {
	
	CSS("cssselector"), 
	ID("id"), 
	NAME("name"), 
	LINK_TEXT("linktext"),
	TAG_NAME("tagname"),
	XPATH("xpath"),
	CLASS_NAME("classname");
	
	private String selectorName;

	LocatorsType(String selectorName) {
		this.selectorName = selectorName;
	}

	public String getSelectorName() {
		return selectorName;
	}
	

}
