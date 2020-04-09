package com.example.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pandhuta Bangkit S 09/04/2020
 */

@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cust_id;
	private String cust_name;
	private String cust_address;

	public Customers() {

	}

	public Customers(long cust_id, String cust_name, String cust_address) {
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_address = cust_address;
	}


	public long getCust_id() {
		return cust_id;
	}

	public void  setCust_id(long cust_id) {
		this.cust_id= cust_id;
	}


	@Column(name = "cust_name", nullable = false)
	public String getCust_name(){
		return cust_name;
	}

	public void setCust_name(String cust_name){
		this.cust_name = cust_name;
	}


	@Column(name = "cust_address", nullable = true)
	public String getCust_address(){
		return cust_address;
	}
	
	public void setCust_address(String cust_address){
		this.cust_address = cust_address;
	}

	@Override
	public String toString() {
		return "Customers{" +
				"cust_id=" + cust_id +
				", cust_name='" + cust_name + '\'' +
				", cust_address='" + cust_address + '\'' +
				", String=" + toString() +
				", String=" + toString() +
				'}';
	}
}
