package com.mcdonald.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mcdonald.cls.CountryCity;
import com.mcdonald.cls.CountryCityDAO;
import com.mcdonald.connect.ConnectionFactory;

public class CountryCityUtil implements CountryCityDAO{
	private List<CountryCity> list;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public CountryCityUtil() {
		this.list = new ArrayList<>();
	}
	public CountryCity getCountryAndCity(int cityId) {
		CountryCity cc = new CountryCity();
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM city JOIN country ON city.cityId=country.cityId WHERE city.cityId=?");
			ps.setInt(1, cityId);
			rs = ps.executeQuery();
			while(rs.next()) {
				cc.setCityId(rs.getInt(1));
				cc.setCityName(rs.getString(2));
				cc.setCapital(rs.getBoolean(3));
				cc.setCountryId(rs.getInt(4));
				cc.setCountryName(rs.getString(5));
				cc.setPopulation(rs.getString(6));
			}
			rs.close();
			ps.close();
			return cc;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cc;
	}
	public List<CountryCity> getAllCountriesAndCapitals() {
		try {
			rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM city JOIN country ON city.cityId=country.cityId WHERE isCapital=1");
			while(rs.next()) {
				CountryCity cc = new CountryCity();
				cc.setCityId(rs.getInt(1));
				cc.setCityName(rs.getString(2));
				cc.setCapital(rs.getBoolean(3));
				cc.setCountryId(rs.getInt(4));
				cc.setCountryName(rs.getString(5));
				cc.setPopulation(rs.getString(6));
				list.add(cc);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
