package com.mcdonald.extras;

public class Country {
	private String name, pop;
	private int id, cityId;
	
	public Country() {}
	
	public Country(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Country(String name, String pop, int id) {
		super();
		this.name = name;
		this.pop = pop;
		this.id = id;
	}

	public Country(String name, String pop, int id, int cityId) {
		super();
		this.name = name;
		this.pop = pop;
		this.id = id;
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPop() {
		return pop;
	}

	public void setPop(String pop) {
		this.pop = pop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
}
