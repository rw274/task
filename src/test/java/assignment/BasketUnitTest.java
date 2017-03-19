package assignment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import assignment.Basket;
import assignment.PriceTicker;
import assignment.domain.Fruit;
import assignment.domain.FruitName;

public class BasketUnitTest {

	private PriceTicker priceTicker;
	private Basket basket;

	@Before
	public void setup() {
		priceTicker = new PriceTicker();
		basket = new Basket(priceTicker);
	}
	@Test
	public void calculateWithTwoItems() {
		priceTicker.updatePrice(FruitName.APPLES, 10d);
		priceTicker.updatePrice(FruitName.BANANAS, 20d);
		priceTicker.updatePrice(FruitName.LEMONS, 30d);
		priceTicker.updatePrice(FruitName.ORANGES, 40d);
		priceTicker.updatePrice(FruitName.PEACHES, 50d);

		basket.updateBasket(new Fruit(FruitName.APPLES, 10));
		basket.updateBasket(new Fruit(FruitName.BANANAS, 10));

		assertEquals(300d, basket.calculateValueOfBasket(), 0.01);
	}
	@Test
	public void calculateWithMissingPrice() {
		priceTicker.updatePrice(FruitName.APPLES, 10d);

		basket.updateBasket(new Fruit(FruitName.APPLES, 10));
		basket.updateBasket(new Fruit(FruitName.BANANAS, 10));

		assertEquals(100d, basket.calculateValueOfBasket(), 0.01);
	}

	@Test
	public void calculateWithUpdatedFruit() {
		priceTicker.updatePrice(FruitName.APPLES, 10d);
		priceTicker.updatePrice(FruitName.BANANAS, 10d);
		basket.updateBasket(new Fruit(FruitName.APPLES, 10));
		assertEquals(100d, basket.calculateValueOfBasket(), 0.01);

		basket.updateBasket(new Fruit(FruitName.APPLES, 20));
		basket.updateBasket(new Fruit(FruitName.BANANAS, 10));
		assertEquals(300d, basket.calculateValueOfBasket(), 0.01);
	}

	@Test
	public void testUpdatingOfExistingFruit() {

		basket.updateBasket(new Fruit(FruitName.APPLES, 10));
		Fruit fruit = basket.getFruit(FruitName.APPLES);
		assertEquals(10, fruit.getAmountOfFruit());

		basket.updateBasket(new Fruit(FruitName.APPLES, 20));
		assertEquals(20, basket.getFruit(FruitName.APPLES).getAmountOfFruit());
	}
}