package assignment.domain;

public enum FruitName {

	APPLES("Apples"), BANANAS("Bananas"), LEMONS("Lemons"), ORANGES(
			"Oranges"), PEACHES("Peaches");

	private String name;

	FruitName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
