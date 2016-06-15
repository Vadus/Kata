package org.klarblick.kata.checkout;

import java.util.HashMap;
import java.util.Map;

public class PricingRules {

	private Map<String, Integer> prices = new HashMap<>();
	
	private SpecialPrice specialPrice;
	
	public PricingRules add(String item, int price){
		prices.put(item, price);
		return this;
	}
	
	public PricingRules withSpecialAmount(int amount){
		createSpecialPrice();
		specialPrice.setAmount(amount);
		return this;
	}

	public PricingRules forTotal(int total){
		createSpecialPrice();
		specialPrice.setTotalPrice(total);
		return this;
	}
	
	private void createSpecialPrice() {
		if(specialPrice == null){
			specialPrice = new SpecialPrice();
		}
	}

	public SpecialPrice getSpecialPrice() {
		return specialPrice;
	}
	public void setSpecialPrice(SpecialPrice specialPrice) {
		this.specialPrice = specialPrice;
	}
	
	public int getPrice(String item){
		return prices.get(item);
	}
}
