package enumerations;

public enum FishLivEnv {

	FRESH_WATER("Fresh Water"), SEA_WATER("Sea Water");

	private String name;

	private FishLivEnv(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
