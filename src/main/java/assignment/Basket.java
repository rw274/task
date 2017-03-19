package assignment;

import java.util.concurrent.ConcurrentHashMap;

import assignment.domain.Fruit;
import assignment.domain.FruitName;

public class Basket {

	private ConcurrentHashMap<FruitName, Fruit> itemsInBasket = new ConcurrentHashMap<>();
	private PriceTicker priceTicker;

	// Constructor injection
	public Basket(PriceTicker priceTicker) {
		this.priceTicker = priceTicker;
	}

	public synchronized void updateBasket(Fruit fruit) {
		itemsInBasket.put(fruit.getName(), fruit);
	}

	// Returns a thread safe copy
	public Fruit getFruit(FruitName fruitName) {
		return itemsInBasket.get(fruitName).copy();
	}

	/*
	 * As an initial approach, the basket is locked during calculation. This
	 * might not be optimal (in that it is not a granular enough locking
	 * solution), but would depend on the application.
	 */
	public synchronized Double calculateValueOfBasket() {
		return itemsInBasket.reduceValuesToDouble(1l,
				x -> x.getAmountOfFruit()
						* priceTicker.getFruitPrice(x.getName()),
				0d, (a, b) -> a + b);
	}

}
