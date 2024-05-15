package com.java.Ecommerce.main;

import java.sql.SQLException;
import java.util.List;

import com.java.Ecommerce.model.Customers;
import com.java.Ecommerce.dao.CustomerDao;
import com.java.Ecommerce.dao.CustomerDaoimp;



public class showCustomerss {
	public static void main(String[] args) 
	{ 
		

	        CustomerDao dao = new CustomerDaoimp();

	        try {

	            List<Customers> customersList = dao.getAllCustomers();

	            if (!customersList.isEmpty()) {

	                System.out.println("List of Customers:");

	                for (Customers customer : customersList) {

	                    System.out.println(customer);

	                }

	            } else {

	                System.out.println("*** No Customers Found ***");

	            }

	        } catch (ClassNotFoundException | SQLException e) {

	            e.printStackTrace();

	        }

	    }
	}


