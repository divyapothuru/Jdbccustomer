package com.customer.dao;

import java.util.Date;

public class Customer {
	private int custId;
	private String name;
	private String phone;
	private  String email;
	private Date birthDate;
	private String address;
	private long purchaseCapacity;
	public Customer(int custId, String name, String phone, String email, Date birthDate, String address,
			long purchaseCapacity) {
		this.custId = custId;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		this.address = address;
		this.purchaseCapacity = purchaseCapacity;
	}
	public Customer() {
		
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPurchaseCapacity() {
		return purchaseCapacity;
	}
	public void setPurchaseCapacity(long purchaseCapacity) {
		this.purchaseCapacity = purchaseCapacity;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [custId=");
		builder.append(custId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", birthDate=");
		builder.append(birthDate);
		builder.append(", address=");
		builder.append(address);
		builder.append(", purchaseCapacity=");
		builder.append(purchaseCapacity);
		builder.append("]");
		return builder.toString();
	}
	
	
}
