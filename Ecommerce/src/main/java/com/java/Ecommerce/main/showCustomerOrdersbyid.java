package com.java.Ecommerce.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.java.Ecommerce.dao.orderDaoimp;
import com.java.Ecommerce.dao.ordersDao;
import com.java.Ecommerce.model.orders;

public class showCustomerOrdersbyid {
	public static void main(String[] args) {		
		int custId;		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter Customer Id ");		
		custId = sc.nextInt();		
		ordersDao dao = new orderDaoimp();		
		try 
		{			
			List<orders> ordersList = dao.showCustomerOrders(custId);			
			for (orders orders : ordersList) 
			{				
				System.out.println(orders);			
				}		
			} 
		catch (ClassNotFoundException | SQLException e) 
		{			// TODO Auto-generated catch block			
			e.printStackTrace();		
			}
	}
}



