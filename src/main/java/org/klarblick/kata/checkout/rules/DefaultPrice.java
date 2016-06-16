package org.klarblick.kata.checkout.rules;

public class DefaultPrice implements PricingRule{

	private String item;
	private int price;
	
	private PricingRule specialRule;
	
	protected DefaultPrice(){
	}
	
	public void setItem(String item){
		this.item = item;
	}
	
	public void setPrice(int price){
		this.price = price;
	}
	
	public DefaultPrice(String item, int price) {
		this.item = item;
		this.price = price;
	}
	
	public <T extends PricingRule> T withSpecial(T specialRule){
		this.specialRule = specialRule;
		this.specialRule.setItem(item);
		this.specialRule.setPrice(price);
		return specialRule;
	}
	
	@Override
	public String getItem() {
		return item;
	}
	
	@Override
	public int calculatePrice(int amount) {
		if(specialRule != null){
			return specialRule.calculatePrice(amount);
		}
		else{
			return amount * price;
		}
	}

	public int getDefaultPrice() {
		return price;
	}
}
