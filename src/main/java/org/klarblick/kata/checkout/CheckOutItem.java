package org.klarblick.kata.checkout;

public class CheckOutItem {

	private String item;
	
	private int amount;
	
	private PricingRule pricingRule;
	
	public CheckOutItem(String item, int amount, PricingRule pricingRule) {
		this.item = item;
		this.amount = amount;
		this.pricingRule = pricingRule;
	}

	public String getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}
	
	public void increaseAmount(){
		amount++;
	}
	
	public int calculatePrice(){
		return pricingRule.calculatePrice(getAmount());
	}
}
