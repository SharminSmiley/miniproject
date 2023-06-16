package com.kce.Railway.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil  {
	static Connection con;
	public static void createDBConnection()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/3306","root","Sharmin@09");
		}catch(ClassNotFoundException e)
		{
		System.out.println(e);	
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return;
	}
	

}
