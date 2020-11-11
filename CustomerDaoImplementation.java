package com.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;

public class CustomerDaoImplementation implements CustomerDao{
	Customer customer=null;
	List<Customer> CustomerList=null;
	List<Customer> ListByPurchaseCapacity=null;
	Connection connection=(Connection) ConnectionFactory.getConnection();
	
	public CustomerDaoImplementation() {
		customer=new Customer();
		CustomerList=new ArrayList<>();
		ListByPurchaseCapacity=new ArrayList<>();
	}
	
	@Override
	public List<Customer> getSelectedCustomer(long purchaseCapacity) throws DaoException {
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("select * from Customer where purchaseCapacity=?");
			pst.setLong(1, purchaseCapacity);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				customer=new Customer();
				customer.setCustId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setPhone(rs.getLong(3));
				customer.setEmail(rs.getString(4));
				customer.setBirthDate(rs.getDate(5));
				customer.setAddress(rs.getString(6));
				customer.setPurchaseCapacity(rs.getLong(7));
				ListByPurchaseCapacity.add(customer);
			}	
		} catch (SQLException e) {
			throw new DaoException("There is an error to get the cusotmer deatails by purchaseCapacity...");	
		}
		return ListByPurchaseCapacity;
	}

	@Override
	public List<Customer> getAllCustomers() throws DaoException {
		
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("select * from Customer");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				customer=new Customer();
				customer.setCustId(rs.getInt(1));
				customer.setName(rs.getString(2));
				customer.setPhone(rs.getLong(3));
				customer.setEmail(rs.getString(4));
				customer.setBirthDate(rs.getDate(5));
				customer.setAddress(rs.getString(6));
				customer.setPurchaseCapacity(rs.getLong(7));
				CustomerList.add(customer);
			}	
		} catch (SQLException e) {
			throw new DaoException("There is an error to get all the customers...");	
		}
		return CustomerList;
	}

	@Override
	public void addCustomer(Customer customer) throws DaoException {
		try {
			PreparedStatement pst=connection.prepareStatement("insert into Customer(custId,name,phone,email,birthDate,address,purchaseCapacity)values(?,?,?,?,?,?,?)");
			pst.setInt(1, customer.getCustId());
			pst.setString(2, customer.getName());
			pst.setLong(3, customer.getPhone());
			pst.setString(4, customer.getEmail());
			pst.setDate(5, (Date) customer.getBirthDate());
			pst.setString(6, customer.getAddress());
			pst.setLong(7, customer.getPurchaseCapacity());
			pst.executeUpdate();
			System.out.println("\n Customer added Successfully...");
		}catch (SQLException e) {
			throw new DaoException("customer cannot be added...");
		}
		
	}

	@Override
	public void deleteCustomer(int custId) throws DaoException {
		try {
			PreparedStatement pst=connection.prepareStatement("delete from Customer where custId=?");
			pst.setInt(1, customer.getCustId());
			pst.executeUpdate();
			System.out.println("deleted the record of Customer successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("customer cannot be deleted!!...");
		}
		
		
		
	}

	@Override
	public void updateCustomer(int custId, long purchaseCapacity) throws DaoException {
		try {
			PreparedStatement pst=connection.prepareStatement("update Customer set purchaseCapacity=? where custId=?");
			pst.setLong(1, purchaseCapacity);
			pst.setInt(2, custId);
			pst.executeUpdate();
			System.out.println("updated the record of Customer successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("customer cannot be updated!!...");
		}
		
		
	}

	@Override
	public Customer getCustomerById(int custId) throws DaoException {
		PreparedStatement pst;
		Customer customerId = new Customer();
		try {
			pst = connection.prepareStatement("select * from Customer where custId=?");
			pst.setInt(1, custId);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				customerId.setCustId(rs.getInt(1));
				customerId.setName(rs.getString(2));
				customerId.setPhone(rs.getLong(3));
				customerId.setEmail(rs.getString(4));
				customerId.setBirthDate(rs.getDate(5));
				customerId.setAddress(rs.getString(6));
				customerId.setPurchaseCapacity(rs.getLong(7));
			}
			else	throw new DaoException("You have entered incorrect Id..."+custId);
		} catch (SQLException e) {
			throw new DaoException("There is an error to get the cusotmer deatails by purchaseCapacity...");	
		}
		return customerId;
	}


}
