package com.onlineHotel_21718.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlineHotel_21718.pojo.Hotel;
import com.onlineHotel_21718.pojo.Room;
import com.onlineHotel_21718.utility.DBUtility;

public class RoomDaoImpl implements RoomDao {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	int rows;
	

	@Override
	public boolean addRoom(Room r) {
		try {
			con=DBUtility.getDBConnect();
		String sql="insert into Room_712(hotelId,roomType,roomCharge,roomNumbers)values(?,?,?,?)";
		
			ps=con.prepareStatement(sql);
			ps.setInt(1, r.getHotelId());
			ps.setString(2, r.getRoomType());
			ps.setDouble(3, r.getRoomCharge());
			ps.setInt(4, r.getRoomNumbers());
			
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
	public boolean updateRoom(Room r) {
		try {
			con=DBUtility.getDBConnect();
		String sql="update Room_712 set hotelId=?,roomType=?,roomCharge=?,roomNumbers=? where roomId=? ";
		
			ps=con.prepareStatement(sql);
			ps.setInt(1, r.getHotelId());
			ps.setString(2, r.getRoomType());
			ps.setDouble(3, r.getRoomCharge());
			ps.setInt(4, r.getRoomNumbers());
			
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
	public List<Room> getRoomByHotelId(int hotelId) {
		List<Room> rlist=new ArrayList<>();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Room_712  where hotelId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, hotelId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Room r=new  Room();
				r.setRoomId(rs.getInt("roomId"));
				r.setHotelId(rs.getInt("hotelId"));
				r.setRoomType(rs.getString("roomType"));
				r.setRoomCharge(rs.getDouble("roomCharge"));
				r.setRoomNumbers(rs.getInt("roomNumbers"));
				rlist.add(r);
				System.out.println("chget"+r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rlist;
	}

	@Override
	public List<Room> displayAllRooms() {
		return null;
	/*	Room r=new  Room();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from room_21718;";
		
			ps=con.prepareStatement(sql);
			
		
			rs=ps.executeQuery();
			if(rs.next())
			{
				r.setRoomId(rs.getInt("roomId"));
				r.setHotelId(rs.getInt("hotelId"));
				r.setRoomType(rs.getString("roomType"));
				r.setRoomCharge(rs.getDouble("roomCharge"));
				r.setRoomNumbers(rs.getInt("roomNumbers"));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	*/
	}

	@Override
	public boolean deleteHotelByRoomId(int roomId) {
		try {
			con=DBUtility.getDBConnect();
		String sql="delete from room_21718  where roomId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, roomId);
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
	public Room getRoomByType(String roomType) {
		Room r=new  Room();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from room_21718  where roomType=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, roomType);
			rs=ps.executeQuery();
			if(rs.next())
			{
				r.setRoomId(rs.getInt("roomId"));
				r.setHotelId(rs.getInt("hotelId"));
				r.setRoomType(rs.getString("roomType"));
				r.setRoomCharge(rs.getDouble("roomCharge"));
				r.setRoomNumbers(rs.getInt("roomNumbers"));
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;

}

	@Override
	public Room groupByHotelId(Room r) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Room groupByHotelId(Room r) {
		
		try {
			con=DBUtility.getDBConnect();
		String sql="select * room_21718 group by hotelId ";
		
			ps=con.prepareStatement(sql);
			ps.setInt(1, r.getHotelId());
			ps.setString(2, r.getRoomType());
			ps.setDouble(3, r.getRoomCharge());
			ps.setInt(4, r.getRoomNumbers());
			
			rows=ps.executeUpdate();
			if(rows>0)
				flag=true;
			else
				flag=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;*/
		
	}

