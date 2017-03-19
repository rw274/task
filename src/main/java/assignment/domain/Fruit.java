package assignment.domain;

//Simple thread safe (immutable) implementation of a class that stores the number of fruit
public class Fruit {

	private final int amountOfFruit;
	private final FruitName fruitName;

	public Fruit(FruitName fruitName, int amountOfFruit) {
		this.amountOfFruit = amountOfFruit;
		this.fruitName = fruitName;
	}

	public int getAmountOfFruit() {
		return amountOfFruit;
	}

	public FruitName getName() {
		return fruitName;
	}

	/*
	 * An explicit copy method; alternatively a copy constructor could have been
	 * used
	 */
	public Fruit copy() {
		return new Fruit(this.fruitName, this.amountOfFruit);

	}
}
