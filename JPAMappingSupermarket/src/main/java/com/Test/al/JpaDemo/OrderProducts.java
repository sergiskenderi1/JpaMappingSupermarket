package com.Test.al.JpaDemo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderproducts")
public class OrderProducts {

	private int id;
	private int orderquantity;
	private float price;
	private StoreProduct storeproduct;
	private Orders orders;
	
	public OrderProducts() {
		
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

	public int getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(int orderquantity) {
		this.orderquantity = orderquantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idproduct")
	public StoreProduct getStoreproduct() {
		return storeproduct;
	}

	public void setStoreproduct(StoreProduct storeproduct) {
		this.storeproduct = storeproduct;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idorder")
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
