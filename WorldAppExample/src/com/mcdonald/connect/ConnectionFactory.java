package com.mcdonald.connect;

import java.sql.*;

public class ConnectionFactory {
	public static final String URL = "jdbc:mysql://database-3.cgsyjtny2rf9.us-east-2.rds.amazonaws.com/worldapp";
	public static final String USER = "admin";
	public static final String PASS = "admin123";

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
