package com.java.Ecommerce.main; 
import java.sql.SQLException; 
import java.util.Scanner; 
import com.java.Ecommerce.dao.CustomerDao; 
import com.java.Ecommerce.dao.CustomerDaoimp;
public class authentication 
{ 
	public static void main(String[] args) { 
		String Email, password; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Email "); 
		Email = sc.next(); 
		System.out.println("Enter Password "); 
		password = sc.next(); 
		CustomerDao c = new CustomerDaoimp(); 
		try 
		{ 
			int count = c.authenticateCustomer(Email, password); 
			if (count==1) 
			{ System.out.println("Correct Credentials..."); 
			} 
			else 
			{ 
				System.out.println("Invalid Credentials..."); 
				} 
			} catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
				e.printStackTrace(); } } 
		
	}
		
