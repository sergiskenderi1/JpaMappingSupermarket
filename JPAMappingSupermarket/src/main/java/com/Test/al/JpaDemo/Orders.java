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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	private int id ;
	private String date ;
	private float orderprice;
	private String message ;
	private Store store;
	private State state;
	private User employee;
	private User client;
	private Set<OrderProducts> orderproducts = new HashSet<OrderProducts>();
	
	public Orders() {
		
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(float orderprice) {
		this.orderprice = orderprice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idstore")
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idstate")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idemployee")
	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idclient")
	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	@OneToMany(mappedBy = "orders",fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<OrderProducts> getOrderproducts() {
		return orderproducts;
	}

	public void setOrderproducts(Set<OrderProducts> orderproducts) {
		this.orderproducts = orderproducts;
	}
		
}
