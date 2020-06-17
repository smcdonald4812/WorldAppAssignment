package com.mcdonald.extras;

public class City {
	private String name;
	private int id;
	private boolean isCap;
	
	public City() {}
	
	public City(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public City(String name, int id, boolean isCap) {
		super();
		this.name = name;
		this.id = id;
		this.isCap = isCap;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCap() {
		return isCap;
	}
	public void setCap(boolean isCap) {
		this.isCap = isCap;
	}
}
