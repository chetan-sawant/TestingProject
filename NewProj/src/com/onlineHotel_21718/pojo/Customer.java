package com.onlineHotel_21718.pojo;

public class Customer 
{
	
	
	
	private int custId,custContact;
	private String custName,custEmail,custPass,custAddress;
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getCustContact() {
		return custContact;
	}
	public void setCustContact(int custContact) {
		this.custContact = custContact;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustPass() {
		return custPass;
	}
	public void setCustPass(String custPass) {
		this.custPass = custPass;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	
	
	
	public String toString() {
		return "Customer [custId=" + custId + ", custContact=" + custContact + ", custName=" + custName + ", custEmail="
				+ custEmail + ", custAddress=" + custAddress + "]";
	}

}
