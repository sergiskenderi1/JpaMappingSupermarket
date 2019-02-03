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
@Table(name = "storeproduct")
public class StoreProduct {

	private int id;
	private int quantity;
	private Store store;
	private Product product;
	private Set<OrderProducts> orders = new HashSet<OrderProducts>();
	
	public StoreProduct() {
		
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idstore")
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idproduct")
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@OneToMany(mappedBy = "storeproduct", fetch = FetchType.LAZY,cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<OrderProducts> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderProducts> orders) {
		this.orders = orders;
	}
	
}
