package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.Album;

public interface IAlbumService {
 	//Album getAlbumById(int id);
 	//List<Album> getAlbumByArtist();
 	List<Album> getAlbumByGenre(String genreName);
 	List<Album> findAll();
 	//Album getAlbumByName(String name);
 	//boolean addAccount(Album account);
 	//Album findOne(String name);
 	//void update(Album acc);
}
