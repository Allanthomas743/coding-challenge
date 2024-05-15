package com.java.Ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Ecommerce.model.OrderDetails;
import com.java.Ecommerce.model.products;
import com.java.Ecommerce.util.DBConnUtil;
import com.java.Ecommerce.util.DBPropertyUtil;

public class OrderDetailsDaoimp implements OrderDetailsDao {
	Connection connection; 
	PreparedStatement pst;

	public int generateOrderId() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select max(order_id)+1 mid from Orders";
		pst = connection.prepareStatement(cmd); 
		ResultSet rs = pst.executeQuery(); 
		rs.next(); 
		int oid = rs.getInt("mid"); 
		return oid;
		
	}
	public int generateOrderDetailsId() throws ClassNotFoundException, SQLException { 
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select max(order_item_id)+1 mid from order_items";
		pst = connection.prepareStatement(cmd); 
		ResultSet rs = pst.executeQuery(); 
		rs.next(); 
		int oid = rs.getInt("mid"); 
		return oid; 
		}
	@Override
	public List<OrderDetails> showCustomerOrderDetails(int custId) throws ClassNotFoundException, SQLException 
	{ 
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from order_items where order_id IN " + " (select order_id from Orders where customer_id=?)"; 
		pst = connection.prepareStatement(cmd); 
		pst.setInt(1, custId); 
		ResultSet rs = pst.executeQuery(); 
		List<OrderDetails> listOrderDetails = new ArrayList<OrderDetails>(); 
		OrderDetails orderDetails = null; 
		while(rs.next()) 
		{ 
			orderDetails = new OrderDetails(); 
			orderDetails.setOrder_id(rs.getInt("OrderId")); 
			orderDetails.setOrder_id(rs.getInt("OrderDetailID")); 
			orderDetails.setProduct_id(rs.getInt("ProductId")); 
			orderDetails.setQuantity(rs.getInt("Quantity")); 
			listOrderDetails.add(orderDetails); } 
		return listOrderDetails; }

	@Override
	public String placeOrder(int custId, int productId, int quantityOrderd)
			throws ClassNotFoundException, SQLException {
		productsDao dao = new productDaoimp();		
		products products = dao.searchByProductId(productId);		
		double price = products.getPrice();		
		double billAmount = quantityOrderd * price;		
		int orderId = generateOrderId();		
		int orderDetailsId = generateOrderDetailsId();		
		String connStr = DBPropertyUtil.connectionString("db");		
		connection = DBConnUtil.getConnection(connStr);		
		String cmd = "Insert into Orders(OrderId, CustomerID, OrderDate, "				+ "TotalAmount) values(?,?,?,?)";		
		pst = connection.prepareStatement(cmd);		
		pst.setInt(1, orderId);		
		pst.setInt(2, custId);		
		pst.setDate(3, new java.sql.Date(new java.util.Date().getTime()));		
		pst.setDouble(4, billAmount);		
		pst.executeUpdate();		
		cmd = "Insert into OrderDetails(OrderDetailID, OrderId, ProductId, "				+ "Quantity) values(?,?,?,?)";		
		pst = connection.prepareStatement(cmd);		
		pst.setInt(1, orderDetailsId);		
		pst.setInt(2, orderId);		
		pst.setInt(3, productId);		
		pst.setInt(4, quantityOrderd);		
		pst.executeUpdate();		
		return "Order Placed Successfully...BillAmount Calculated...";
		
	}

}
