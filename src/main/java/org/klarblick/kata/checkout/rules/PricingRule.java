package org.klarblick.kata.checkout.rules;

public interface PricingRule {

	String getItem();

	int calculatePrice(int amount);
	
	void setItem(String item);
	
	void setPrice(int price);

}