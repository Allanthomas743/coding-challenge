package com.java.Ecommerce.model;

public class OrderDetails {
	private int order_item_id; 
	private int order_id; 
	private int product_id; 
	private int quantity;
	private int item_amount;
	public int getOrder_item_id() {
		return order_item_id;
	}
	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItem_amount() {
		return item_amount;
	}
	public void setItem_amount(int item_amount) {
		this.item_amount = item_amount;
	}
	public OrderDetails() {
		
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int order_item_id, int order_id, int product_id, int quantity, int item_amount) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.item_amount = item_amount;
	}
	@Override
	public String toString() {
		return "OrderDetails [order_item_id=" + order_item_id + ", order_id=" + order_id + ", product_id=" + product_id
				+ ", quantity=" + quantity + ", item_amount=" + item_amount + "]";
	}
	
	

}
