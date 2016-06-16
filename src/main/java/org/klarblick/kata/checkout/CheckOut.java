package org.klarblick.kata.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {

	private PricingRules pricingRules;
	private Map<String, CheckOutItem> items = new HashMap<>();
	
	
	public CheckOut(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	public void scan(String item){
		
		CheckOutItem coItem = items.get(item);
		if(coItem == null){
			coItem = new CheckOutItem(item, 0, pricingRules.getPricingRule(item));
			items.put(item, coItem);
		}
		coItem.increaseAmount();
	}
	
	public int total(){
		
		int total = items.values()
				.parallelStream()
				.mapToInt(CheckOutItem::calculatePrice)
				.sum();
		
		return total;
	}
}
