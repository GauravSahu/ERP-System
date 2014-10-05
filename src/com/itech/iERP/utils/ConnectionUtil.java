package com.itech.iERP.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	
	static
	{
	try

		{
			Class.forName("com.mysql.jdbc.Driver");
			
		}
	catch (ClassNotFoundException ex) 
	{
		ex.printStackTrace();
	}
	}			
	       
		
			 public static Connection getMySqlConnection() throws SQLException
		   
	          {
			     	return  DriverManager.getConnection("jdbc:mysql://localhost:3306/iERP","root","root");
		      }
	    
	public  static void closeResources(Connection con,Statement stmt,ResultSet rs) 
	                                         throws SQLException
	{
		if(rs!=null)
		{
			rs.close();
			rs = null;
			}
		if(stmt!=null)
		{
			stmt.close();
			stmt = null;
			}
		if(con!=null)
		{
			con.close();
			con = null;
			}
		
		
		}

}
