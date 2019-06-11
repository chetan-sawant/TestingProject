package com.onlineHotel_21718.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlineHotel_21718.pojo.Booking;

import com.onlineHotel_21718.utility.DBUtility;

public class BookingDaoImpl implements BookingDao{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	String sql;
	int rows;
	int totalCharges,bookedrooms,totalRooms,charges,bookingId;
	@Override
	public int addBooking(Booking b) {
		System.out.println("M - BookingDaoImpl - addBooking");
		try {
			con=DBUtility.getDBConnect();
			
			sql="select sum(numberofRooms) from booking_712 where roomId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, b.getRoomId());
			rs=ps.executeQuery();
			if(rs.next())
				bookedrooms=rs.getInt(1);

			sql="select roomNumbers,roomCharge from room_712 where roomId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, b.getRoomId());
			rs=ps.executeQuery();
			if(rs.next())
			{
				totalRooms=rs.getInt(1);
				charges=rs.getInt(2);
			}

			if(totalRooms-bookedrooms>=b.getCount())
			{
				totalCharges=charges*(b.getNumberofDays())*(b.getNumberofRooms());
		
			sql="insert into booking_712(roomId,custEmail,startDate,endDate,numberofRooms,totalCharges)values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			//ps=con.prepareStatement(sql);
			ps.setInt(1, b.getRoomId());
			ps.setString(2, b.getCustEmail());
			ps.setString(3, b.getStartDate());
			ps.setString(4, b.getEndDate());
			ps.setInt(5, b.getNumberofRooms());
			ps.setInt(6, totalCharges);
			rows=ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs != null && rs.next())
			{
				System.out.println("Generated Emp Id: "+rs.getInt(1));
				bookingId=rs.getInt(1);
			}
			}

			else
			{
				bookingId=-1;
			}
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return bookingId;
	}

	@Override
	public boolean updateBooking(Booking b) {
		try {
			con=DBUtility.getDBConnect();
		String sql="update booking_21718 set roomId=?,custEmail=?,startDate=?,endDate=?,numberofRooms=? where bookingId=?";
		
			ps=con.prepareStatement(sql);
			ps.setInt(1, b.getRoomId());
			ps.setString(2, b.getCustEmail());
			ps.setString(3, b.getStartDate());
			ps.setString(4, b.getEndDate());
			ps.setInt(5, b.getNumberofRooms());
			ps.setInt(6, b.getBookingId());
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
	public boolean deleteBookingById(int bookingId) {
		try {
			con=DBUtility.getDBConnect();
		String sql="delete from booking_21718  where bookingId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, bookingId);
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
	public Booking getBookingByEmail(String custEmail) {
		Booking b=new  Booking();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from booking_21718  where custEmail=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, custEmail);
			rs=ps.executeQuery();
			if(rs.next())
			{
				b.setBookingId(rs.getInt("bookingId"));
				b.setRoomId(rs.getInt("roomId"));
				b.setEmailId(rs.getString("custEmail"));
				b.setStartDate(rs.getString("startDate"));
				b.setEndDate(rs.getString("endDate"));
				b.setNumberofRooms(rs.getInt("numberofRooms"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public List<Booking> displayAllBookings() {
		List<Booking>clist=new ArrayList<>();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from booking_21718 ";
		
			ps=con.prepareStatement(sql);
			
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				Booking b=new Booking();
				b.setBookingId(rs.getInt("bookingId"));
				b.setRoomId(rs.getInt("roomId"));
				b.setEmailId(rs.getString("custEmail"));
				b.setStartDate(rs.getString("startDate"));
				b.setEndDate(rs.getString("endDate"));
				b.setNumberofRooms(rs.getInt("numberofRooms"));
				clist.add(b);
			}
				
			}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return clist;
	}

}
