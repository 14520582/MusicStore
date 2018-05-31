package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.Artist;
import com.musicstore.entity.Genre;

public interface IGenreService {
	Genre findByName(String name);
	List<Genre> findAll();
	Genre save(Genre g);

}
