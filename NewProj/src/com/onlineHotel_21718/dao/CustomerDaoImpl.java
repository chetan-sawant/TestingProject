package com.onlineHotel_21718.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.onlineHotel_21718.pojo.Customer;
import com.onlineHotel_21718.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	boolean flag;
	int rows;

	@Override
	public boolean addCustomer(Customer c) {
		try {
			con=DBUtility.getDBConnect();
		String sql="insert into Customer_712(custName,custEmail,custPass,custAdress,custContact)values(?,?,?,?,?)";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getCustEmail());
			ps.setString(3, c.getCustPass());
			ps.setString(4, c.getCustAddress());
			ps.setInt(5, c.getCustContact());
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
	public boolean updateCustomer(Customer c) {
		try {
			con=DBUtility.getDBConnect();
		String sql="update Customer_712 set custName=?,custEmail=?,custPass=?,custAdress=?,custContact=? where custId=?";
		
			ps=con.prepareStatement(sql);
			ps.setString(1, c.getCustName());
			ps.setString(2, c.getCustEmail());
			ps.setString(3, c.getCustPass());
			ps.setString(4, c.getCustAddress());
			ps.setInt(5, c.getCustContact());
			ps.setInt(6, c.getCustId());
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
	public boolean deleteCustomerById(int custId) {
		try {
			con=DBUtility.getDBConnect();
		String sql="delete from Customer_712  where custId=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, custId);
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
	public Customer getCustomerByEmail(String custEmail) {
		Customer c=new  Customer();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Customer_712  where custEmail=?";
		
			ps=con.prepareStatement(sql);
			
			ps.setString(1, custEmail);
			rs=ps.executeQuery();
			if(rs.next())
			{
				c.setCustId(rs.getInt("custId"));
				c.setCustName(rs.getString("custName"));
				c.setCustEmail(rs.getString("custEmail"));
				c.setCustContact(rs.getInt("custContact"));
				c.setCustAddress(rs.getString("custAdress"));
				c.setCustPass(rs.getString("custPass"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	
		
	}

	@Override
	public List<Customer> displayAllCustomers() {
		List<Customer>clist=new ArrayList<>();
		try {
			con=DBUtility.getDBConnect();
		String sql="select * from Customer_712 ";
		
			ps=con.prepareStatement(sql);
			
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				Customer c=new Customer();
				c.setCustId(rs.getInt("custId"));
				c.setCustName(rs.getString("custName"));
				c.setCustEmail(rs.getString("custEmail"));
				c.setCustContact(rs.getInt("custContact"));
				c.setCustAddress(rs.getString("custAdress"));
				c.setCustPass(rs.getString("custPass"));
				clist.add(c);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clist;
		
		
	}

}
