package com.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="customer")
public class Customer {

	//Customer_id , Customer_name , Customer_phone_num , Customer_Address
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String customer_name;
	private String phone_number;
	private String Address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_name=" + customer_name + ", phone_number=" + phone_number
				+ ", Address=" + Address + "]";
	}
//	public Customer(int id, String customer_name, String phone_number, String address) {
//		super();
//		this.id = id;
//		this.customer_name = customer_name;
//		this.phone_number = phone_number;
//		Address = address;
//	}
	public Customer() {
		super();
	}
	
	
	
	
}
