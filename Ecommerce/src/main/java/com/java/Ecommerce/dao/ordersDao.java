package com.java.Ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.Ecommerce.model.orders;

public interface ordersDao {
	List<orders> showCustomerOrders(int custId) throws ClassNotFoundException, SQLException;
	String PlaceOrder(int custId,int product_id) throws ClassNotFoundException, SQLException;

}
