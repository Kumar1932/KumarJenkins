package com.Vtiger.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility 
{
	Connection conn;
	public void getDbConnection(String url,String username,String password) throws SQLException
	{
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("url","username","password");
		}
		catch(Exception e){	
		}
	}
	
	public void getDbConnection() throws SQLException
	{
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm","root","root");
		}
		catch(Exception e){	
		}
	}
	
	public void closeDbConnection()
	{
		try {
			conn.close();
		}
		catch(Exception e){	
		}
	}
	public ResultSet executeSelectQuery(String query) throws SQLException
	{
		ResultSet result = null;
		try {
		Statement stat = conn.createStatement();
		result = stat.executeQuery(query);
		}
		catch(Exception e) {
		}
		return result;
	}
	public int executeNonSelectQuery(String query)
	{
		int result = 0;
		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		}
		catch(Exception e) {
			
		}
		return result;
	}
}
