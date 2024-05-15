package com.java.Ecommerce.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.Ecommerce.dao.productsDao;
import com.java.Ecommerce.dao.productDaoimp;

import com.java.Ecommerce.model.products;

public class searchbyproductid {
	public static void main(String[] args) 
	{ 
		int id; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Product Id "); 
		id = sc.nextInt(); 
		productsDao dao = new productDaoimp(); 
		try 
		{ 
			products product = dao.searchByProductId(id); 
			if (product !=null) 
			{ 
				System.out.println(product);
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
