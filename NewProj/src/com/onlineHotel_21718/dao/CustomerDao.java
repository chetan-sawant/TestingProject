package com.onlineHotel_21718.dao;

import java.util.List;

import com.onlineHotel_21718.pojo.Customer;

public interface CustomerDao 
{
	boolean addCustomer(Customer c);
	boolean updateCustomer(Customer c);
	boolean deleteCustomerById(int custId);
	Customer getCustomerByEmail(String custEmail);
	List<Customer> displayAllCustomers();

}
