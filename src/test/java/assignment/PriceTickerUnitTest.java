package assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment.PriceTicker;
import assignment.domain.FruitName;

public class PriceTickerUnitTest {

	@Test
	public void test() {
		PriceTicker priceTicker = new PriceTicker();
		priceTicker.updatePrice(FruitName.APPLES, 10d);

		assertEquals(10d, priceTicker.getFruitPrice(FruitName.APPLES), 0.01d);
		assertEquals(0d, priceTicker.getFruitPrice(FruitName.BANANAS), 0.01d);
	}

}
