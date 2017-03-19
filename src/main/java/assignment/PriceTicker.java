package assignment;

import java.util.concurrent.ConcurrentHashMap;

import assignment.domain.FruitName;

public class PriceTicker {

	private ConcurrentHashMap<FruitName, Double> fruitPrices = new ConcurrentHashMap<>();

	public void updatePrice(FruitName fruitName, Double price) {
		fruitPrices.put(fruitName, price);
	}

	/*
	 * Returns the most up to date price. If it's necessary to price a basket
	 * using all prices at a given time instant, this class would need to be
	 * extended so that historical prices are stored, together with a time stamp
	 */
	public Double getFruitPrice(FruitName fruitName) {
		Double price = fruitPrices.get(fruitName);
		return price == null ? 0d : price;
	}

}
