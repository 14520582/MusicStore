package com.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.AlbumDAO;
import com.musicstore.entity.Album;
@Service(value = "albumService")
public class AlbumService implements IAlbumService{
	@Autowired
	private AlbumDAO albumDAO;
	@Override
	public List<Album> getAlbumByGenre(String genreName) {
		return albumDAO.getAlbumByGenre(genreName);
	}
	@Override
	public List<Album> findAll() {
		return (List<Album>) albumDAO.findAll();
	}

}
