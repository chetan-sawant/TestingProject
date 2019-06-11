package com.onlineHotel_21718.dao;

import java.util.List;

import com.onlineHotel_21718.pojo.Booking;


public interface BookingDao
{
	int addBooking(Booking b);
	boolean updateBooking(Booking b);
	boolean deleteBookingById(int bookingId);
	Booking getBookingByEmail(String custEmail);
	List<Booking> displayAllBookings();
	

}
