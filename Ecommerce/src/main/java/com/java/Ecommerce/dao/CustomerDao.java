package com.java.Ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.Ecommerce.model.Customers;

public interface CustomerDao {
	List<Customers> showCustomerDao() throws ClassNotFoundException, SQLException; 
	Customers searchByCustomerId(int custId) throws ClassNotFoundException, SQLException;
	Customers searchByEmail(String Email) throws ClassNotFoundException, SQLException;
	List<Customers> getAllCustomers() throws ClassNotFoundException, SQLException;
	int authenticateCustomer(String Email,String password) throws ClassNotFoundException, SQLException;
	void updatingpwd(String password,String Email) throws ClassNotFoundException, SQLException;
	
}
