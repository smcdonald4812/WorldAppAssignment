package com.mcdonald.cls;

public class CountryCity {
	private String countryName, cityName, population, flag = "not";
	private int countryId, cityId;
	private boolean isCapital;
	
	public CountryCity() {}
	public CountryCity(int countryId, int cityId) {
		super();
		this.countryId = countryId;
		this.cityId = cityId;
	}
	public CountryCity(String countryName, String cityName, int countryId, int cityId) {
		super();
		this.countryName = countryName;
		this.cityName = cityName;
		this.countryId = countryId;
		this.cityId = cityId;
	}
	public CountryCity(String countryName, String cityName, String population, int countryId, int cityId,
			boolean isCapital) {
		super();
		this.countryName = countryName;
		this.cityName = cityName;
		this.population = population;
		this.countryId = countryId;
		this.cityId = cityId;
		this.isCapital = isCapital;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		if(isCapital) {
			flag = "";
		}
		this.isCapital = isCapital;
	}
	@Override
	public String toString() {
		return "Country: " + countryName + ", City: " + cityName + ", Country Poupulation: " + population
				+ ", Country ID: " + countryId + ", City ID:" + cityId + ", "+cityName+" is"+flag+" the capital of "+countryName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
}
