package com.onlineHotel_21718.pojo;
import java.io.*;

public class Hotel {
	private int hotelId, hotelContact;
	private String hotelName,hotelLocation;
	private InputStream is;

	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelContact=" + hotelContact + ", hotelName=" + hotelName
				+ ", hotelLocation=" + hotelLocation + "]";
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getHotelContact() {
		return hotelContact;
	}
	public void setHotelContact(int hotelContact) {
		this.hotelContact = hotelContact;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	
}
