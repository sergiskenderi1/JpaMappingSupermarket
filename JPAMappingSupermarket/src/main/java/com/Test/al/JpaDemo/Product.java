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
@Table(name = "product")
public class Product {

	private int id ;
	private String name;
	private float price;
	private Set<StoreProduct> storeproduct = new HashSet<StoreProduct>();
	
	public Product() {
		
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY, cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<StoreProduct> getStoreproduct() {
		return storeproduct;
	}

	public void setStoreproduct(Set<StoreProduct> storeproduct) {
		this.storeproduct = storeproduct;
	}
	
	
}
