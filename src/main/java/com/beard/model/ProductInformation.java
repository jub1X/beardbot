package com.beard.model;

public class ProductInformation {

	private String productLink;
	private String productCode;
	private ClothingType clothingType;

	public ProductInformation(String productLink, String productCode, ClothingType clothingType) {
		this.productLink = productLink;
		this.productCode = productCode;
		this.clothingType = clothingType;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public ClothingType getClothingType() {
		return clothingType;
	}

	public void setClothingType(ClothingType clothingType) {
		this.clothingType = clothingType;
	}
	
}
