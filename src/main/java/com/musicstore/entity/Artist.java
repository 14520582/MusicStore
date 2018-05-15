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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="artist")
public class Artist implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;  
	@Column(name="name")
    private String name;
	@Column(name="year_of_birth")
    private int yearofbirth;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_country", nullable = false)
    private Country country;
	@Column(name="sex")
    private int sex; //1: male 0: female
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
	public int getYearofbirth() {
		return yearofbirth;
	}
	public void setYearofbirth(int yearofbirth) {
		this.yearofbirth = yearofbirth;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Artist(Integer id, String name, int yearofbirth, Country country, int sex) {
		super();
		this.id = id;
		this.name = name;
		this.yearofbirth = yearofbirth;
		this.country = country;
		this.sex = sex;
	}
	public Artist(String name, int yearofbirth, Country country, int sex) {
		super();
		this.name = name;
		this.yearofbirth = yearofbirth;
		this.country = country;
		this.sex = sex;
	}
	public Artist() {
		super();
	}
	
}
