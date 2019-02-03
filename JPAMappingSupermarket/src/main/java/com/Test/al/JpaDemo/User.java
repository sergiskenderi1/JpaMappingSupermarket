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
@Table(name = "user")
public class User {

	private int id;
	private String username;
	private String lastname;
	private String password;
	private String address;
	private String email;
	private String mobile ;
	private Role role ;
	private Store store;
	private Set<Orders> clientorders = new HashSet<Orders>();
	private Set<Orders> employeeorders = new HashSet<Orders>();
	
	public User() {
		
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idrole")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "idstore")
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@OneToMany(mappedBy = "client",fetch = FetchType.LAZY, cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<Orders> getClientorders() {
		return clientorders;
	}

	public void setClientorders(Set<Orders> clientorders) {
		this.clientorders = clientorders;
	}

	@OneToMany(mappedBy = "employee",fetch = FetchType.LAZY, cascade = CascadeType.ALL,
			orphanRemoval = true)
	public Set<Orders> getEmployeeorders() {
		return employeeorders;
	}

	public void setEmployeeorders(Set<Orders> employeeorders) {
		this.employeeorders = employeeorders;
	}
	
	
}
