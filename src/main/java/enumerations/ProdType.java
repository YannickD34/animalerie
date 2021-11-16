package enumerations;

public enum ProdType {

	FOOD("Food"), ACCESSORY("Accessory"), CLEANING("Cleaning");

	private String name;

	private ProdType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
