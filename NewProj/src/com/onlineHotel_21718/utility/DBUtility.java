package com.onlineHotel_21718.utility;

import java.sql.*;

public class DBUtility 
{
	public static Connection getDBConnect()
	{
		Connection con=null;
		
		
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineHotel_712","root","");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return con;
		
		
		
	}

}
