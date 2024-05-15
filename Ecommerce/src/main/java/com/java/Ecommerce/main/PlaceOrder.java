package com.java.Ecommerce.main;
import com.java.Ecommerce.dao.OrderDetailsDao;
import com.java.Ecommerce.dao.OrderDetailsDaoimp;

import java.sql.SQLException;
import java.util.Scanner;

public class PlaceOrder {
	public static void main(String[] args) 
	{ 
		int custId, productId, quantityOrd; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Customer Id "); 
		custId = sc.nextInt(); 
		System.out.println("Enter Product Id "); 
		productId = sc.nextInt(); 
		System.out.println("Enter Quantity Ordered "); 
		quantityOrd = sc.nextInt(); 
		OrderDetailsDao dao = new OrderDetailsDaoimp(); 
		try { 
			System.out.println(dao.placeOrder(custId, productId, quantityOrd));
			
		}
		catch (ClassNotFoundException | SQLException e) 
		{ // TODO Auto-generated catch block 
			e.printStackTrace();
			}
	}

}
