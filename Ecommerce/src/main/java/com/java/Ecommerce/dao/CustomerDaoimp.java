package com.java.Ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Ecommerce.model.Customers;
import com.java.Ecommerce.util.DBConnUtil;
import com.java.Ecommerce.util.DBPropertyUtil;

public class CustomerDaoimp implements CustomerDao {
	Connection connection;
	PreparedStatement pst;

	@Override
	public List<Customers> showCustomerDao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from customers"; 
		pst = connection.prepareStatement(cmd); 
		ResultSet rs = pst.executeQuery(); 
		List<Customers> customerList = new ArrayList<Customers>(); 
		Customers customer = null; 
		while(rs.next()) 
		{ 
			customer = new Customers(); 
			customer.setCustomer_id(rs.getInt("customer_id")); 
			customer.setFirstName(rs.getString("firstName")); 
			customer.setLastName(rs.getString("lastName")); 
			customer.setEmail(rs.getString("Email")); 
			customer.setPhone(rs.getString("address")); 
			customer.setAddress(rs.getString("password")); 
			customerList.add(customer);
			} 
		return customerList;
		
	}

	@Override
	public Customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from customers where customer_id = ?"; 
		pst = connection.prepareStatement(cmd); 
		pst.setInt(1, custId); 
		ResultSet rs = pst.executeQuery(); 
		Customers customer = null; 
		if(rs.next()) 
		{ 
			customer = new Customers(); 
			customer.setCustomer_id(rs.getInt("customer_id")); 
			customer.setFirstName(rs.getString("FirstName")); 
			customer.setLastName(rs.getString("lastName")); 
			customer.setEmail(rs.getString("Email")); 
			customer.setPhone(rs.getString("address")); 
			customer.setAddress(rs.getString("password")); 
			} return customer;
		
	}

	@Override
	public Customers searchByEmail(String Email) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from customers where Email = ?"; 
		pst = connection.prepareStatement(cmd); 
		pst.setString(1, Email); 
		ResultSet rs = pst.executeQuery(); 
		Customers customer = null; 
		if(rs.next()) 
		{ 
			customer = new Customers(); 
			customer.setCustomer_id(rs.getInt("customer_id")); 
			customer.setFirstName(rs.getString("FirstName")); 
			customer.setLastName(rs.getString("lastName")); 
			customer.setEmail(rs.getString("Email")); 
			customer.setPhone(rs.getString("address")); 
			customer.setAddress(rs.getString("password")); 
			} return customer;
	}
@Override
public List<Customers> getAllCustomers() throws ClassNotFoundException, SQLException {
		

			String connStr = DBPropertyUtil.connectionString("db");

			connection = DBConnUtil.getConnection(connStr);

			String cmd = "select * from customers";

			pst = connection.prepareStatement(cmd);

			ResultSet rs = pst.executeQuery();

			List<Customers> customerList = new ArrayList<Customers>();

			Customers customer = null;

			while(rs.next()) {

				customer = new Customers();

				customer.setCustomer_id(rs.getInt("customer_Id"));

				customer.setFirstName(rs.getString("firstName"));

				customer.setLastName(rs.getString("lastName"));

				customer.setEmail(rs.getString("Email"));



				customer.setAddress(rs.getString("address"));
				
				

				customerList.add(customer);

			}

			return customerList;

		
		
	}
	

}
