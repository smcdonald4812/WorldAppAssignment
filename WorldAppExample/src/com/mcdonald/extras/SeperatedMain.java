package com.mcdonald.extras;

import java.util.stream.Stream;

public class SeperatedMain {
	public static void main(String[] args) {
		CountryDAO counD = new CountryUtil();
		CityDAO cityD = new CityUtil();
		Stream.of("City,Country Id,Country,Population,City Id".split(",")).forEach(x->System.out.printf("%-15s", x, " "));
		System.out.println();
		Stream.of(cityD.getCountryAndCity(3).split(",")).forEach(x->System.out.printf("%-15s", x, " "));
		System.out.println();
		counD.getAllCountriesAndCapitals().stream().forEach(x->{Stream.of(x.split(",")).forEach(y -> System.out.printf("%-15s", y, " "));System.out.println();});
	}
}
