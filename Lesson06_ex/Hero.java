class Hero {
	private String name;
	private int level;

	// add here	
	Hero(){
		this.setName("ヒーロー");
		this.setLevel(0);
	}

	
	void setName(String name) {
		// add here
		if(name.length() >= 1 && name.length() <= 8){
			this.name = name;
		}
	}

	void setLevel(int level) {
		// add here
		if(level >= 0 && level <= 100){
			this.level = level;
		}
	}

	String getName() {
		// add here
		return this.name;
	}

	int getLevel() {
		// add here
		return this.level;
	}
}
