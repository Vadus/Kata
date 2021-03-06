package org.klarblick.kata.checkout.rules;

import java.util.HashMap;
import java.util.Map;

/**
 * Container for {@link PricingRule}s
 * 
 * @author dtramnitzke
 *
 */
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
