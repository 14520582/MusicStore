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

@Entity
@Table(name="detail_order")
public class DetailOrder implements Serializable  {
	private static final long serialVersionUID = 11L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_album", nullable = false)
	private Album album;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_order", nullable = false)
	private Order order;
	@Column(name="quanlity")
	private int quanlity;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
	public DetailOrder(Integer id, Album album, Order order, int quanlity) {
		super();
		this.id = id;
		this.album = album;
		this.order = order;
		this.quanlity = quanlity;
	}
	public DetailOrder(Album album, Order order, int quanlity) {
		super();
		this.album = album;
		this.order = order;
		this.quanlity = quanlity;
	}
	public DetailOrder() {
		super();
	}
	
}
