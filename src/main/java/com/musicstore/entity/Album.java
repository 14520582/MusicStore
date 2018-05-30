package com.musicstore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@Lob 
	@Column(name="description",length = 100000)
    private String description;
	@Column(name="quantity")	
	private int quantity = 0;
	@OneToMany(mappedBy="album", cascade = CascadeType.ALL, targetEntity = Song.class)
	private List<Song> songs = new ArrayList<Song>();
	@Column(name="status")	
	private int status = 1;
	public Album() {
		super();
	}
	
	public Album(Integer id, String name, int price, Genre genre, Artist artist, long releasedate, String cover,
			String description, int quantity, List<Song> songs, int status) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
		this.cover = cover;
		this.description = description;
		this.quantity = quantity;
		this.songs = songs;
		this.status = status;
	}
	
	public Album(String name, int price, Genre genre, Artist artist, long releasedate, String cover, String description,
			int quantity, List<Song> songs, int status) {
		super();
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.artist = artist;
		this.releasedate = releasedate;
		this.cover = cover;
		this.description = description;
		this.quantity = quantity;
		this.songs = songs;
		this.status = status;
	}
	public void addSong(Song e){
		songs.add(e);
	}
	public List<Song> getSongs() {
		return songs;
	}
	public void clearSongs() {
		this.songs.clear();
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Artist getArtist() {
		return artist;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
}
