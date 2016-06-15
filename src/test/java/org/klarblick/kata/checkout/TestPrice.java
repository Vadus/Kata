package org.klarblick.kata.checkout;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestPrice {
	
	private PricingRules rules;
	
	@Before
	public void init(){
		rules = new PricingRules();
		rules.add("A", 40).withSpecialAmount(3).forTotal(100);
		rules.add("B", 50).withSpecialAmount(2).forTotal(80);
		rules.add("C", 25);
		rules.add("D", 20);
	}

	@Test
	public void testTotals() {

		assertEquals(0, calculatePrice(""));

		assertEquals(40, calculatePrice("A"));

		assertEquals(90, calculatePrice("AB"));

		assertEquals(135, calculatePrice("CDBA"));

		assertEquals(80, calculatePrice("AA"));

		assertEquals(100, calculatePrice("AAA"));

		assertEquals(140, calculatePrice("AAAA"));

		assertEquals(180, calculatePrice("AAAAA"));

		assertEquals(200, calculatePrice("AAAAAA"));

		assertEquals(150, calculatePrice("AAAB"));

		assertEquals(180, calculatePrice("AAABB"));

		assertEquals(200, calculatePrice("AAABBD"));

		assertEquals(200, calculatePrice("DABABA"));

	}

	@Test

	public void testIncremental() {

		CheckOut co = new CheckOut(rules);

		assertEquals(0, co.total());

		co.scan("A");
		assertEquals(40, co.total());

		co.scan("B");
		assertEquals(90, co.total());

		co.scan("A");
		assertEquals(130, co.total());

		co.scan("A");
		assertEquals(150, co.total());

		co.scan("B");
		assertEquals(180, co.total());

	}

	private int calculatePrice(String goods) {
	
		CheckOut co = new CheckOut(rules);
	
//		goods.chars()
//			.mapToObj(c -> (char)c)
//			.forEach(c -> co.scan(String.valueOf(c)));
		
		for (int i = 0; i < goods.length(); i++) {
	
			co.scan(String.valueOf(goods.charAt(i)));
	
		}
	
		return co.total();
	
	}

}
