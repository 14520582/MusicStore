package com.musicstore.service;

import java.util.List;

import com.musicstore.entity.Song;

public interface ISongService {
	List<Song>	findAll();
	void deleteById(int id);
	Song addSong(Song s);
}
