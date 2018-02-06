package com.musicstore.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	@Column(name="name")
    private String name;
	public Integer getId() {
		return id;
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
	public Country(String name) {
		super();
		this.name = name;
	}
	public Country(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Country() {
		super();
	}
	
}
