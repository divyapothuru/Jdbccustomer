package connection;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

import com.customer.dao.Customer;
import com.customer.dao.CustomerDao;
import com.customer.dao.CustomerDaoImplementation;
import com.customer.dao.DaoException;

import java.util.*;
public class Testing {
	public static void main(String[] args) {
CustomerDao customerDao=null;
		
//		adding customer into databse
	
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d/MM/yyy");
		String dateString="01/01/1993";
		LocalDate utilDate=LocalDate.parse(dateString,formatter);
		Date birthDate = Date.valueOf(utilDate);
		try {
			customerDao=new CustomerDaoImplementation();
			customerDao.addCustomer(new Customer(3, "divya", 1345678122, "divya@gmail.com",birthDate, "noida", 10));
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
		//printing all the customers from the database
		try {
			customerDao=new CustomerDaoImplementation();
			List<Customer> allCustomers= customerDao.getAllCustomers();
			allCustomers.forEach(System.out::println);
			} catch (DaoException e) {
			e.printStackTrace();
		}

		//deleting the record based on id from customer database
		try {
			customerDao=new CustomerDaoImplementation();
			customerDao.deleteCustomer(2);
		}catch (DaoException e) {
			e.printStackTrace();
			
		}
		
		// updating customer by their purchaseCapacity
		try {
		customerDao=new CustomerDaoImplementation();
			customerDao.updateCustomer(2, 2100);
		}catch (DaoException e) {
			e.printStackTrace();
			
		}
		
		
		//printing customer details specified by customer purchaseCapacity
		try {
			customerDao=new CustomerDaoImplementation();
			List<Customer> customersByPurchaseCapacity= customerDao.getSelectedCustomer(245);
			System.out.println("\n printing customer details specified by customer purchaseCapacity");
			customersByPurchaseCapacity.forEach(System.out::println);
			} catch (DaoException e) {
			e.printStackTrace();
		}
		
		//printing customer details specified by customer purchaseCapacity
		try {
			customerDao=new CustomerDaoImplementation();
			Customer customersById= customerDao.getCustomerById(2);
			customersById.toString();
			} catch (DaoException e) {
			e.printStackTrace();
		}

}
}

