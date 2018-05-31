package com.musicstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="orders")
public class Orders implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	
	@Column(name="date")
	private long date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer", nullable = false)
	@JsonIgnoreProperties({"token", "password", "role"})
	private Account customer;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL, targetEntity = DetailOrder.class)
	private List<DetailOrder> details = new ArrayList<DetailOrder>();
	@Column(name="status")
	private int status; // 0: new 1: confirm and delivery 2: ended
	@Column(name="address")
	private String address;
	@Column(name="name")
	private String name; 
	@Column(name="phone")
	private String phone; 
	@Column(name="payment")
	private int payment; 
	public void addDetails(DetailOrder e){
		details.add(e);
	}
	public Integer getId() {
		return id;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<DetailOrder> getDetails() {
		return details;
	}
	public void setDetails(List<DetailOrder> details) {
		this.details = details;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Orders(Integer id, long date, Account customer, List<DetailOrder> details, int status) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.details = details;
		this.status = status;
	}
	public Orders(long date, Account customer, List<DetailOrder> details, int status) {
		super();
		this.date = date;
		this.customer = customer;
		this.details = details;
		this.status = status;
	}
	public Orders(long date, Account customer, List<DetailOrder> details) {
		super();
		this.date = date;
		this.customer = customer;
		this.details = details;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public Account getCustomer() {
		return customer;
	}
	public void setCustomer(Account customer) {
		this.customer = customer;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public Orders(Integer id, long date, Account customer) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
	}
	
	public Orders(Integer id, long date, Account customer, List<DetailOrder> details) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.details = details;
	}
	
	public Orders(Integer id, long date, Account customer, List<DetailOrder> details, int status, String address,
			String name, String phone, int payment) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.details = details;
		this.status = status;
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.payment = payment;
	}
	public Orders(long date, Account customer, List<DetailOrder> details, int status, String address, String name,
			String phone, int payment) {
		super();
		this.date = date;
		this.customer = customer;
		this.details = details;
		this.status = status;
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.payment = payment;
	}
	public Orders(long date, Account customer) {
		super();
		this.date = date;
		this.customer = customer;
	}
	public Orders() {
		super();
	}
	
}
