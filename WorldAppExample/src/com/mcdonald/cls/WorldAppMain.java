package com.mcdonald.cls;

import com.mcdonald.util.CountryCityUtil;

public class WorldAppMain {
	public static void main(String[] args) {
		CountryCityDAO ccDAO = new CountryCityUtil();
		System.out.println(ccDAO.getCountryAndCity(3).toString());
		System.out.println();
		ccDAO.getAllCountriesAndCapitals().stream().forEach(x -> System.out.println(x.toString()));
		
	}
}
