package com.java.Ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Ecommerce.model.orders;
import com.java.Ecommerce.util.DBConnUtil;
import com.java.Ecommerce.util.DBPropertyUtil;

public class orderDaoimp implements ordersDao {
	Connection connection;
	PreparedStatement pst;
	

	@Override
	public List<orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from Orders where customer_id = ?"; 
		pst = connection.prepareStatement(cmd); 
		pst.setInt(1, custId); 
		ResultSet rs = pst.executeQuery(); 
		List<orders> ordersList = new ArrayList<orders>();
		orders order = null; 
		while(rs.next()) 
		{ 
			order = new orders(); 
			order.setCustomer_id(rs.getInt("customer_id")); 
			order.setOrder_id(rs.getInt("order_id")); 
			order.setOrder_date(rs.getDate("order_date")); 
			order.setTotal_price(rs.getDouble("total_price")); 
			ordersList.add(order);
		} 
		return ordersList;
		
	}


	@Override
	public String PlaceOrder(int custId, int product_id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}



	

}
