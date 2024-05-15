package com.java.Ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.Ecommerce.model.Customers;
import com.java.Ecommerce.util.DBConnUtil;
import com.java.Ecommerce.util.DBPropertyUtil;

public class AuthenticateCustoremDao implements Atuthenticate {
	//private static final String EncryptPassword = null;
	//private static final String SendMail = null;
	Connection connection;	
	PreparedStatement pst;		
	@Override	public String addCustomer(Customers customer) throws ClassNotFoundException, SQLException {				
		String connStr = DBPropertyUtil.connectionString("db");		
		connection = DBConnUtil.getConnection(connStr);				
		String pwd = EncryptPassword.getCode(customer.getPassword());		
		customer.setPassword(pwd);				
		String cmd = "Insert into Customer(CustomerId, FirstName, LastName, "				+ "Email,Address, Password) "				+ " values(?,?,?,?,?,?)";				
		pst = connection.prepareStatement(cmd);		
		pst.setInt(1, customer.getCustomer_id());		
		pst.setString(2, customer.getFirstName());		
		pst.setString(3, customer.getLastName());		
		pst.setString(4, customer.getEmail());
		pst.setString(6, customer.getAddress());
		pst.setString(8, customer.getPassword());
		pst.executeUpdate();
		SendMail.mailSend("ksstshivendra26@gmail.com", "Java Mail Working Fine", "Hexaware Trainng");
		return "Customer Record Inserted...";	}	
	@Override	public int authenticateCustomer(String user, String pwd) throws ClassNotFoundException, SQLException 
	{		
		String connStr = DBPropertyUtil.connectionString("db");
		connection = DBConnUtil.getConnection(connStr);
		String encr = EncryptPassword.getCode(pwd);
		String cmd = "select count(*) cnt from Customer where UserName = ? "				+ " AND Password = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, user);
		pst.setString(2, encr);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int cnt = rs.getInt("cnt");
		return cnt;
		}
	}
	}

}
