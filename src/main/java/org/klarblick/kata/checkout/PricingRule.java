package org.klarblick.kata.checkout;

public class PricingRule {

	private String item;
	private int price;
	private SpecialPrice specialPrice;
	
	public PricingRule(String item, int price) {
		this.item = item;
		this.price = price;
	}
	
	public PricingRule withSpecialAmount(int amount){
		createSpecialPrice();
		specialPrice.setAmount(amount);
		return this;
	}

	public PricingRule forTotal(int total){
		createSpecialPrice();
		specialPrice.setTotalPrice(total);
		return this;
	}
	
	private void createSpecialPrice() {
		if(specialPrice == null){
			specialPrice = new SpecialPrice();
		}
	}

	public String getItem() {
		return item;
	}

	public int calculatePrice(int amount) {
		if(specialPrice != null){
			
			int specialPriceQuantity = amount/specialPrice.getAmount();
			int specialTotal = specialPrice.getTotalPrice() * specialPriceQuantity;
			
			int restQuantity = amount - (specialPrice.getAmount() * specialPriceQuantity);
			
			
			return specialTotal + restQuantity * price;
		}
		else{
			return price * amount;
		}
	}

	public SpecialPrice getSpecialPrice() {
		return specialPrice;
	}
	
}
