package com.onlineHotel_21718.pojo;

public class Room 
{
	
	int roomId;
	int hotelId;
	String roomType;
	double roomCharge;
	int roomNumbers;
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", hotelId=" + hotelId + ", roomType=" + roomType + ", roomCharges="
				+ roomCharge + ", roomNumbers=" + roomNumbers + "]";
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public double getRoomCharge() {
		return roomCharge;
	}
	public void setRoomCharge(double roomCharge) {
		this.roomCharge = roomCharge;
	}
	public int getRoomNumbers() {
		return roomNumbers;
	}
	public void setRoomNumbers(int roomNumbers) {
		this.roomNumbers = roomNumbers;
	}


}
