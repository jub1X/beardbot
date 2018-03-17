package com.beard.model;

public enum ClothingType {
	
	JACKETS("jackets"),
	SHIRTS("shirts"),
	SWEATERS("tops-sweaters"),
	SWEATSHIRTS("sweatshirts"),
	PANTS("pants"),
	TSHIRT("t-shirts"),
	HATS("hats"),
	BAGS("bags"),
	ACCESSORIES("accessories"),
	SHOES("shoes"),
	SKATE("skate"),
	NA("NA");
	
	String str;
	
	ClothingType(String str){
		this.str = str;
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static ClothingType returnClothingTypeFromStr(String str) {
		for(ClothingType clothingType : ClothingType.values()) {
			if(clothingType.getStr().contains(str))
				return clothingType;
		}
		return ClothingType.NA;
	}

	public String getStr() {
		return str;
	}
	
}
