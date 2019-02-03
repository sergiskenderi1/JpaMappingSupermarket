package com.Test.al.JpaDemo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "store")
public class Store {

	private int id;
	private String name;
	private String address;
	private String mobile;
	private Set<User> employee = new HashSet<User>();
	private Set<StoreProduct> storeproduct = new HashSet<StoreProduct>();
	private Set<Orders> orders = new HashSet<Orders>();
	
	public Store() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@OneToMany(mappedBy = "store" , fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			orphanRemoval= true)
	public Set<User> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<User> employee) {
		this.employee = employee;
	}

	@OneToMany(mappedBy = "store",fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<StoreProduct> getStoreproduct() {
		return storeproduct;
	}

	public void setStoreproduct(Set<StoreProduct> storeproduct) {
		this.storeproduct = storeproduct;
	}

	@OneToMany(mappedBy = "store",fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
}
