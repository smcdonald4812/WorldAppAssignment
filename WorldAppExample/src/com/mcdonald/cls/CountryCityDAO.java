package com.mcdonald.cls;

import java.util.List;

public interface CountryCityDAO {
	public CountryCity getCountryAndCity(int cityId);
	public List<CountryCity> getAllCountriesAndCapitals();
}
