package com.onlineHotel_21718.dao;

import java.util.List;

import com.onlineHotel_21718.pojo.Hotel;

public interface LoginDao {
	
		boolean adminLogin(String email,String password);
		boolean UserLogin(String userEmail,String password);
		boolean changePassword(String userEmail,String newPass);
	
}
