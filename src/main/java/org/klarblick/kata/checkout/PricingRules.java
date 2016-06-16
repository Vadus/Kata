package org.klarblick.kata.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

	private Map<String, PricingRule> prices = new HashMap<>();
	
	public PricingRules add(PricingRule rule){
		prices.put(rule.getItem(), rule);
		return this;
	}
	
	public int getPrice(String item, int amount){
		return getPricingRule(item).calculatePrice(amount);
	}
	
	public PricingRule getPricingRule(String item){
		return prices.get(item);
	}
}
