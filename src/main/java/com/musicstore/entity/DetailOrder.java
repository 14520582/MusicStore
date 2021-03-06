package com.musicstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="detail_order")
public class DetailOrder implements Serializable  {
	private static final long serialVersionUID = 8L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_album", nullable = false)
	@JsonIgnoreProperties({"genre", "releasedate", "description", "quantity", "songs"})
	private Album album;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order", nullable = false)
	@JsonIgnoreProperties({"details", "customer"})
	private Orders order;
	@Column(name="quantity")
	private int quantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public DetailOrder(Integer id, Album album, Orders order, int quantity) {
		super();
		this.id = id;
		this.album = album;
		this.order = order;
		this.quantity = quantity;
	}
	public DetailOrder(Album album, Orders order, int quantity) {
		super();
		this.album = album;
		this.order = order;
		this.quantity = quantity;
	}
	public DetailOrder(Album album, int quantity) {
		super();
		this.album = album;
		this.quantity = quantity;
	}
	public DetailOrder() {
		super();
	}
	
}
