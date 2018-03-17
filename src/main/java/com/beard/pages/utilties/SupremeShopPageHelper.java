package com.beard.pages.utilties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.beard.exceptions.BeardRunTimeException;
import com.beard.model.ClothingType;
import com.beard.model.ProductInformation;

public class SupremeShopPageHelper {

	private Pattern PATTERN_LINK = Pattern
			.compile("http:\\/\\/www\\.supremenewyork\\.com\\/shop\\/(\\w*[-\\w.\\W]\\w*)\\/(\\w*)\\/(\\w*)");

	/*
	 * http://www.supremenewyork.com/shop/tops-sweaters/iiz63lnsv/j8p3amqfb
	 * 
	 */
	public List<ProductInformation> trimProductLinkAndCreateProductInformationList(
			Map<String, Boolean> productLinkAndSoldOutStatusMap) throws BeardRunTimeException {
		List<ProductInformation> productInformationList = new ArrayList<ProductInformation>();
		for (Entry<String, Boolean> productLinkAndSoldOutStatus : productLinkAndSoldOutStatusMap.entrySet()) {
			String productLink = productLinkAndSoldOutStatus.getKey();
			Matcher matcher = PATTERN_LINK.matcher(productLink);
			if (!matcher.find()) {
				throw new BeardRunTimeException("ERROR: Failed to find any matches with regex pattern "
						+ PATTERN_LINK.toString() + " with product link " + productLink);
			}
			String productCode = matcher.group(3);
			ClothingType clothingType = ClothingType.returnClothingTypeFromStr(matcher.group(1));
			if (clothingType == ClothingType.NA)
				throw new BeardRunTimeException("ERROR: Failed to find clothing type from value " + matcher.group(1));
			productInformationList.add(new ProductInformation(productLink, productCode, clothingType,
					productLinkAndSoldOutStatus.getValue()));
		}
		return productInformationList;
	}

}
