package com.musicstore.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="account")
public class Account implements Serializable { 
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	@Column(name="name")
    private String name;
	@Column(name="address")	
	private String address;
	@Column(name="role")	
	private String role;
	@Column(name="phone")	
	private String phone;
	@Column(name="email")	
	private String email;
	@Column(name="user_name")	
	private String username;
	@Column(name="pass_word")	
	private String password;
	@Column(name="token")	
	private String token;
	public Account(Integer id, String name, String address, String role, String phone, String username, String password,
			String token) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.token = token;
	}
	
	public Account(Integer id, String name, String address, String role, String phone, String email, String username,
			String password, String token) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public Account(String name, String address, String role, String phone, String email, String username,
			String password, String token) {
		super();
		this.name = name;
		this.address = address;
		this.role = role;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.token = token;
	}

	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Account(int id, String name, String username, String password, String address, String phone, String role) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.role = role;
	}
	public Account() {
		super();
	}
	
} 