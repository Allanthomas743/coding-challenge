package com.java.Ecommerce.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.Ecommerce.model.products;

public interface productsDao {
	List<products> showProductsDao() throws ClassNotFoundException, SQLException;	
	products searchByProductId(int id) throws ClassNotFoundException, SQLException;
	List<products> getAllProducts() throws ClassNotFoundException, SQLException;

}
