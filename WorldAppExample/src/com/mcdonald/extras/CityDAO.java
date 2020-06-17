package com.mcdonald.extras;

import java.util.List;

public interface CityDAO {
	public City getCity(int id);
	public List<City> getAllCities();
	public boolean updateCity(City city);
	public void deleteCity(City city);
	public String getCountryAndCity(int cityId);
}
