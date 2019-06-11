package com.onlineHotel_21718.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlineHotel_21718.pojo.Customer;
import com.onlineHotel_21718.pojo.Hotel;
import com.onlineHotel_21718.utility.DBUtility;

public class HotelDaoImpl implements HotelDao
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	int rows;

	@Override
	public boolean addHotel(Hotel h) {
		try {
			con=DBUtility.getDBConnect();
		String sql="insert into Hotel_712(hotelName,hotelLocation,hotelContact,hotelImage)values(?,?,?,?)";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, h.getHotelName());
			ps.setString(2, h.getHotelLocation());
			ps.setInt(3, h.getHotelContact());
			ps.setBlob(4, h.getIs());
			
			rows=ps.executeUpdate();
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

	@Override
	public boolean updateHotel(Hotel h) {
		try {
			con=DBUtility.getDBConnect();
		String sql="update Hotel_712 set hotelName=?,hotelLocation=?,hotelContact=?,hotelImage=? where hotelId=?";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, h.getHotelName());
			ps.setString(2, h.getHotelLocation());
			ps.setInt(3, h.getHotelContact());
			ps.setBlob(4, h.getIs());
			ps.setInt(5, h.getHotelId());
			
			rows=ps.executeUpdate();
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

	@Override
	public boolean deleteHotelById(int hotelId) {
		try {
			con=DBUtility.getDBConnect();
		String sql="delete from Hotel_712  where hotelId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, hotelId);
			rows=ps.executeUpdate();
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

	@Override
	public Hotel getHotelById(int hotelId) {
		Hotel h=new  Hotel();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Hotel_712  where hotelId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, hotelId);
			rs=ps.executeQuery();
			if(rs.next())
			{
				h.setHotelId(rs.getInt("hotelId"));
				h.setHotelName(rs.getString("hotelName"));
				h.setHotelLocation(rs.getString("hotelLocation"));
				h.setHotelContact(rs.getInt("hotelContact"));
				h.setIs(rs.getBinaryStream("hotelImage"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return h;
	
	}

	@Override
	public List<Hotel> displayAllHotels() {
		List<Hotel>hlist=new ArrayList<>();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Hotel_712 ";
		
			ps=con.prepareStatement(sql);
			
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				Hotel h=new Hotel();
				h.setHotelId(rs.getInt("hotelId"));
				h.setHotelName(rs.getString("hotelName"));
				h.setHotelLocation(rs.getString("hotelLocation"));
				h.setHotelContact(rs.getInt("hotelContact"));
				h.setIs(rs.getBinaryStream("hotelImage"));
				
				hlist.add(h);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			for(Hotel h: hlist){
			System.out.println(h);
		}
		return hlist;
	}

}
