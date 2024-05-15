package com.java.Ecommerce.main;

import java.sql.SQLException;
import java.util.List;

import com.java.Ecommerce.dao.productsDao;
import com.java.Ecommerce.dao.productDaoimp;
import com.java.Ecommerce.model.Customers;
import com.java.Ecommerce.model.products;

public class showProducts {
	public static void main(String[] args) {

        productsDao productsDao = new productDaoimp();

        

        try {

            List<products> productList = productsDao.showProductsDao();

            if (productList.isEmpty()) {

                System.out.println("No products available.");

            } else {

                System.out.println("List of all products:");

                for (products product : productList) {

                    System.out.println(product);

                }

            }

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();

        }

    }



}
