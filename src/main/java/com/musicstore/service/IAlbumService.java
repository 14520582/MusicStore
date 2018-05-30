package com.musicstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.musicstore.entity.Album;

public interface IAlbumService {
 	//Album getAlbumById(int id);
 	//List<Album> getAlbumByArtist();
 	List<Album> getAlbumByGenre(String genreName);
 	List<Album> findAll();
 	Page<Album> findByPage(Pageable pageable);
 	Page<Album> findBySearchTerm(String term, Pageable pageable);
 	Album addAlbum(Album account);
 	Album reduceQuantity(int id, int q);
 	Album findByName(String name);
 	Album getAlbumById(int id);
 	Album update(Album acc);
}
