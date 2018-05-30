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
@Table(name="song")
public class Song implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;  
	@Column(name="name")
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_genre", nullable = false)
	private Genre genre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_singer", nullable = false)
	private Artist singer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_album", nullable = false)
	@JsonIgnoreProperties({"name", "price", "genre", "artist", "releasedate", "cover", "description", "quantity", "songs"})
	private Album album;
	
	public Song() {
		super();
	}	
	
	public Song(Integer id, String name, Genre genre, Artist singer, Album album) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.singer = singer;
		this.album = album;
	}

	public Song(String name, Genre genre, Artist singer, Album album) {
		super();
		this.name = name;
		this.genre = genre;
		this.singer = singer;
		this.album = album;
	}
	public Song(String name, Genre genre, Artist singer) {
		super();
		this.name = name;
		this.genre = genre;
		this.singer = singer;
	}
	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Artist getSinger() {
		return singer;
	}
	public void setSinger(Artist singer) {
		this.singer = singer;
	}
	
}
