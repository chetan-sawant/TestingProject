package com.onlineHotel_21718.pojo;

public class Booking 
{
	
	private int bookingId,numberofRooms,roomId,numberofDays,count;
	private String custEmail,startDate,endDate;
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", numberofRooms=" + numberofRooms + ", roomId=" + roomId
				+ ", custEmail=" + custEmail + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getNumberofRooms() {
		return numberofRooms;
	}
	public void setNumberofRooms(int numberofRooms) {
		this.numberofRooms = numberofRooms;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setEmailId(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getNumberofDays() {
		return numberofDays;
	}
	public void setNumberofDays(int numberofDays) {
		this.numberofDays = numberofDays;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	

}
