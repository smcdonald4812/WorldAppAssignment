package com.mcdonald.extras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mcdonald.connect.ConnectionFactory;

public class CountryUtil implements CountryDAO{
	private List<Country> list;
	private List<String> sList;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public CountryUtil() {
		this.list = new ArrayList<>();
		this.setsList(new ArrayList<>());
	}
	@Override
	public Country getCountry(int id) {
		Country c = new Country();
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM country WHERE countryId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPop(rs.getString(3));
				c.setCityId(rs.getInt(4));
			}
			rs.close();
			ps.close();
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	@Override
	public List<Country> getAllCountries() {
		try {
			rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM country");
			while(rs.next()) {
				Country c = new Country();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPop(rs.getString(3));
				c.setCityId(rs.getInt(4));
				list.add(c);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<String> getAllCountriesAndCapitals() {
		String temp;
		try {
			rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM city JOIN country ON city.cityId=country.cityId WHERE isCapital=1");
			while(rs.next()) {
				temp = "";
				for(int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
					if(i!=3) {
						temp+=rs.getObject(i).toString()+",";
					}
				}
				sList.add(temp);
			}
			rs.close();
			return sList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sList;
	}
	@Override
	public boolean updateCountry(Country c) {
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("UPDATE country SET countryName=?, population=?, cityId=? WHERE countryId=?");
			ps.setString(1, c.getName());
			ps.setString(2, c.getPop());
			ps.setInt(3, c.getCityId());
			ps.setInt(4, c.getId());
			boolean b = ps.execute();
			ps.close();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteCountry(Country c) {
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("DELETE FROM country WHERE countryId=?");
			ps.setInt(1, c.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<String> getsList() {
		return sList;
	}
	public void setsList(List<String> sList) {
		this.sList = sList;
	}
}
