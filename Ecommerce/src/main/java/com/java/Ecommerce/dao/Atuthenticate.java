package com.java.Ecommerce.dao;

import java.sql.SQLException;

import com.java.Ecommerce.model.Customers;

public interface Atuthenticate {
	String addCustomer(Customers customer) throws ClassNotFoundException, SQLException; 
	int authenticateCustomer(String user, String pwd) throws ClassNotFoundException, SQLException;

}
