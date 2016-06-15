package org.klarblick.kata.checkout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.xml.ws.Holder;

public class CheckOut {

	private PricingRules pricingRules;
	private List<String> items = new ArrayList<>();
	
	
	public CheckOut(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	public void scan(String item){
		
		items.add(item);
	}
	
	public int total(){
		
		final Holder<Integer> total = new Holder<>(0);
		
		Map<String, Long> counted = items.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		
		counted.forEach((item, count) -> {
			total.value += pricingRules.getPrice(item, count.intValue());
		});
		
		return total.value;
	}
}
