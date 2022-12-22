package com.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static Connection con;
	public static Connection getConnectedToDb() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sah_utk");
		System.out.println("Connected to Db");
		return con;
	}
}