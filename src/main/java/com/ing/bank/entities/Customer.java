package com.ing.bank.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountNumber;
	private int amount;
	private String name;
	private String phone;
	private String address;
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Customer(int accountNumber, String name, String phone, String address, String password, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.amount = amount;
	}




	public int getAccountNumber() {
		return accountNumber;
	}




	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
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




	public int getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Customer [accountNumber=" + accountNumber + ", name=" + name + ", phone=" + phone + ", address="
				+ address + ", password=" + password + ", amount=" + amount + "]";
	}






	
	
}
