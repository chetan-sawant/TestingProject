package com.onlineHotel_21718.dao;

import java.util.List;

import com.onlineHotel_21718.pojo.Hotel;
import com.onlineHotel_21718.pojo.Room;

public interface RoomDao {
	boolean addRoom(Room r);
	boolean updateRoom(Room r);
	boolean deleteHotelByRoomId(int roomId);
	List<Room> getRoomByHotelId(int hotelId);
	Room getRoomByType(String roomType);
	List<Room> displayAllRooms();
	Room groupByHotelId(Room r);

}
