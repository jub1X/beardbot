package com.beard.model;

public class ProductInformation {

	private String productLink;
	private String productCode;
	private ClothingType clothingType;
	private Boolean isSoldOut;
	


	public ProductInformation(String productLink, String productCode, ClothingType clothingType,Boolean isSoldOut) {
		this.productLink = productLink;
		this.productCode = productCode;
		this.clothingType = clothingType;
		this.isSoldOut = isSoldOut;
	}

	public String getProductLink() {
		return productLink;
	}


	public String getProductCode() {
		return productCode;
	}


	public ClothingType getClothingType() {
		return clothingType;
	}

	public Boolean getIsSoldOut() {
		return isSoldOut;
	}

	@Override
	public String toString() {
		return "ProductInformation [productLink=" + productLink + ", productCode=" + productCode + ", clothingType="
				+ clothingType + ", isSoldOut=" + isSoldOut + "]";
	}
	
}
