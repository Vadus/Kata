package org.klarblick.kata.checkout.rules.specials;

import org.klarblick.kata.checkout.rules.DefaultPrice;

/**
 * Special pricing rule, e.g.: 2 piece of cake for half the price
 * 
 * @author dtramnitzke
 *
 */
public class SomeForLessPrice extends DefaultPrice {

	private SpecialPrice specialPrice;
	
	public SomeForLessPrice() {
	}
	
	public SomeForLessPrice(String item, int price) {
		super(item, price);
	}
	
	public SomeForLessPrice amount(int amount){
		createSpecialPrice();
		specialPrice.setAmount(amount);
		return this;
	}

	public SomeForLessPrice forTotal(int total){
		createSpecialPrice();
		specialPrice.setTotalPrice(total);
		return this;
	}
	
	private void createSpecialPrice() {
		if(specialPrice == null){
			specialPrice = new SpecialPrice();
		}
	}


	/* (non-Javadoc)
	 * @see org.klarblick.kata.checkout.rules.PricingRule#calculatePrice(int)
	 */
	@Override
	public int calculatePrice(int amount) {
		if(specialPrice != null){
			
			int specialPriceQuantity = amount/specialPrice.getAmount();
			int specialTotal = specialPrice.getTotalPrice() * specialPriceQuantity;
			
			int restQuantity = amount - (specialPrice.getAmount() * specialPriceQuantity);
			
			
			return specialTotal + restQuantity * getDefaultPrice();
		}
		else{
			return super.calculatePrice(amount);
		}
	}
	
	private static class SpecialPrice {

		private int amount;
		private int totalPrice;
		
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public int getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
	}
}
