package com.onlineHotel_21718.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlineHotel_21718.pojo.Hotel;
import com.onlineHotel_21718.utility.DBUtility;

public class LoginDaoImpl implements LoginDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	int rows;

	@Override
	public boolean adminLogin(String email, String password) {
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Admin_712  where Email=? and Pass=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Success");
				flag=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return flag;
	}

	@Override
	public boolean UserLogin(String userEmail, String password) {
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Customer_712  where custEmail=? and custPass=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, userEmail);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println("Success");
				flag=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	@Override
	public boolean changePassword(String userEmail, String newPass) {
	
		try {
			con=DBUtility.getDBConnect();
		String sql="update Admin_712 set Pass=? where Email=?";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, newPass);
			ps.setString(2, userEmail);
			rows=ps.executeUpdate();
			System.out.println("update Dao");
			if(rows>0)
				flag=true;
			else
				flag=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
