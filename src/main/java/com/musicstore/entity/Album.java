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
@Table(name="album")
public class Album implements Serializable {
	private static final long serialVersionUID = 2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	@Column(name="name")
    private String name;
	@Column(name="price")	
	private int price;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_genre", nullable = false)
	private Genre genre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_artist", nullable = false)
	private Artist artist;
	@Column(name="release_date")	
	private long releasedate;
	@Column(name="cover")
    private String cover;
	public Album(Integer id, String name, int price, Genre genre, Artist artist, long releasedate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
	}
	public Album(String name, int price, Genre genre, Artist artist, long releasedate) {
		super();
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
	}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public long getReleasedate() {
		return releasedate;
	}
	public void setReleasedate(long releasedate) {
		this.releasedate = releasedate;
	}
	public Album() {
		super();
	}
	public Artist getArtist() {
		return artist;
	}
	public Album(String name, int price, Genre genre, Artist artist, long releasedate, String cover) {
		super();
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
		this.cover = cover;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Album(Integer id, String name, int price, Genre genre, Artist artist, long releasedate, String cover) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
		this.cover = cover;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
}
