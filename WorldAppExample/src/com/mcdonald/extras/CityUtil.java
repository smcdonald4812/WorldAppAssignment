package com.mcdonald.extras;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mcdonald.connect.ConnectionFactory;

public class CityUtil implements CityDAO{
	private List<City> list;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public CityUtil() {
		this.list = new ArrayList<>();
	}
	@Override
	public City getCity(int id) {
		City c = new City();
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM city WHERE cityId=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setCap(rs.getBoolean(3));
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
	public String getCountryAndCity(int cityId) {
		String temp = "";
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("SELECT * FROM city JOIN country ON city.cityId=country.cityId WHERE city.cityId=?");
			ps.setInt(1, cityId);
			rs = ps.executeQuery();
			while(rs.next()) {
				for(int i = 2; i <= rs.getMetaData().getColumnCount();i++) {
					if(i!=3) {
						temp+=rs.getObject(i).toString()+",";
					}
				}
			}
			rs.close();
			ps.close();
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	@Override
	public List<City> getAllCities() {
		try {
			rs = ConnectionFactory.getConnection().createStatement().executeQuery("SELECT * FROM city");
			while(rs.next()) {
				City c = new City();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setCap(rs.getBoolean(3));
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
	public boolean updateCity(City city) {
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("UPDATE city SET name=?, isCapital=? WHERE cityId=?");
			ps.setString(1, city.getName());
			ps.setBoolean(2, city.isCap());
			ps.setInt(3, city.getId());
			boolean b = ps.execute();
			ps.close();
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void deleteCity(City city) {
		try {
			ps = ConnectionFactory.getConnection().prepareStatement("DELETE FROM city WHERE cityId=?");
			ps.setInt(1, city.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
