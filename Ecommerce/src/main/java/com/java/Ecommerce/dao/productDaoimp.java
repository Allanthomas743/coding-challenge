package com.java.Ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Ecommerce.model.Customers;
import com.java.Ecommerce.model.products;
import com.java.Ecommerce.util.DBConnUtil;
import com.java.Ecommerce.util.DBPropertyUtil;

public class productDaoimp implements productsDao {
	Connection connection; 
	PreparedStatement pst; 
	@Override
	public List<products> showProductsDao() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from products"; 
		pst = connection.prepareStatement(cmd); 
		ResultSet rs = pst.executeQuery(); 
		List<products> productsList = new ArrayList<products>(); 
		products products = null; 
		while(rs.next()) 
		{ 
			products = new products(); 
			products.setProduct_id(rs.getInt("product_id")); 
			products.setName(rs.getString("name")); 
			products.setDescription(rs.getString("description")); 
			products.setPrice(rs.getDouble("price")); 
			productsList.add(products); } 
		return productsList;
		
	}

	@Override
	public products searchByProductId(int id) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db"); 
		connection = DBConnUtil.getConnection(connStr); 
		String cmd = "select * from products where product_id = ?"; 
		pst = connection.prepareStatement(cmd); 
		pst.setInt(1, id); 
		ResultSet rs = pst.executeQuery(); 
		products product = null; 
		if(rs.next()) 
		{ 
			product = new products(); 
			product.setProduct_id(rs.getInt("product_id")); 
			product.setName(rs.getString("name")); 
			product.setDescription(rs.getString("description")); 
			product.setPrice(rs.getInt("price")); 
			product.setStockQuantity(rs.getInt("stockquantity"));  
			} return product;
		
		
	}

	@Override
	public List<products> getAllProducts() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.connectionString("db");

        connection = DBConnUtil.getConnection(connStr);

        String cmd = "SELECT * FROM products";

        pst = connection.prepareStatement(cmd);

        ResultSet rs = pst.executeQuery();

        List<products> productList = new ArrayList<>();

        while (rs.next()) {

            products product = new products();

            product.setProduct_id(rs.getInt("product_id"));

            product.setName(rs.getString("name"));

            product.setDescription(rs.getString("description"));

            product.setPrice(rs.getDouble("price"));

            product.setStockQuantity(rs.getInt("stockQuantity"));

            productList.add(product);

        }

        return productList;


		
	}

}
