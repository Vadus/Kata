package org.klarblick.kata.checkout;

public class CheckOut {

	private PricingRules pricingRules;
	private int total;
	
	
	public CheckOut(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	public void scan(String sku){
		
		total+= pricingRules.getPrice(sku);
	}
	
	public int total(){
		return total;
	}
}
