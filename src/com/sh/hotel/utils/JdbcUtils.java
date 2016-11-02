package com.sh.hotel.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JdbcUtils {
	
	private static Connection conn;
	private static DataSource ds = new ComboPooledDataSource();
	
	public static Connection getConnection(){
		
		try {
			conn = ds.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
