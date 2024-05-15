package com.java.Ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Ecommerce.dao.CustomerDao;
import com.java.Ecommerce.dao.CustomerDaoimp;
import com.java.Ecommerce.model.Customers;

public class SearchbyEmail {
	public static void main(String args[]) {
	String Email; 
	Scanner sc = new Scanner(System.in); 
	System.out.println("Enter Email");
	Email = sc.next(); 
	CustomerDao dao = new CustomerDaoimp(); 
	try 
	{ 
		Customers customer = dao.searchByEmail(Email); 
		if (customer !=null) 
		{ 
			System.out.println(customer);
			} 
		else 
		{ 
			System.out.println("*** Customer Record Not Found ***"); 
			} 
		} catch (ClassNotFoundException | SQLException e) 
	{ // TODO Auto-generated catch block 
			e.printStackTrace();
	}
	
	}
}

