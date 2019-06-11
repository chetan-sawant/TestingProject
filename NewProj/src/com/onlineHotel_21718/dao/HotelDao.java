package com.onlineHotel_21718.dao;

import java.util.List;


import com.onlineHotel_21718.pojo.Hotel;

public interface HotelDao {
	boolean addHotel(Hotel h);
	boolean updateHotel(Hotel h);
	boolean deleteHotelById(int hotelId);
	Hotel getHotelById(int hotelId);
	List<Hotel> displayAllHotels();

}
