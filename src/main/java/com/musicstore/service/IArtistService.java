package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.Artist;

public interface IArtistService {
	Artist findByName(String name);
	boolean existsByName(String name);
	List<Artist> findAll();
}
