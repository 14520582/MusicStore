package com.musicstore.service.imp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.ArtistDAO;
import com.musicstore.entity.Artist;
import com.musicstore.service.*;
@Service(value = "artistService")
public class ArtistService implements IArtistService{
	@Autowired
	private ArtistDAO artistDAO;
	@Override
	public Artist findByName(String name) {
		// TODO Auto-generated method stub
		return artistDAO.findByName(name);
	}

	@Override
	public boolean existsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Artist> findAll() {
		// TODO Auto-generated method stub
		return (List<Artist>) artistDAO.findAll();
	}
}
