package com.mcdonald.extras;

import java.util.List;

public interface CountryDAO {
	public Country getCountry(int id);
	public List<Country> getAllCountries();
	public boolean updateCountry(Country country);
	public void deleteCountry(Country country);
	public List<String> getAllCountriesAndCapitals();
}
