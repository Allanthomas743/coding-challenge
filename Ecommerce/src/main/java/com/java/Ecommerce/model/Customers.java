package com.java.Ecommerce.model;

public class Customers {
	private int customer_id; 
	private String firstName; 
	private String lastName; 
	private String Email; 
	private String phone; 
	private String address;
	private String password;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Customers() {
		
		// TODO Auto-generated constructor stub
	}
	public Customers(int customer_id, String firstName, String lastName, String email, String phone, String address,
			String password) {
		
		this.customer_id = customer_id;
		this.firstName = firstName;
		this.lastName = lastName;
		Email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customers [customer_id=" + customer_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Email=" + Email + ", phone=" + phone + ", address=" + address + ", password=" + password + "]";
	}
	
	

}
