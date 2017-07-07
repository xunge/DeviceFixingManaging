package edu.heusoft.DeviceFixingManaging.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	private static String driverClass=null;
	private static String dbUrl=null;
	private static String dbUsername=null;
	private static String dbPassword=null;
	
	static{
		//Load properties
		Properties p=new Properties();
		try {
			p.load(DBUtil.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driverClass=p.getProperty("driver");
		dbUrl=p.getProperty("url");
		dbUsername=p.getProperty("username");
		dbPassword=p.getProperty("password");
		
		//Load driver
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		Connection con=null;
		
		try {
			con=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeResource(ResultSet rs,Statement st,Connection con){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeResource(Statement st,Connection con){
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
