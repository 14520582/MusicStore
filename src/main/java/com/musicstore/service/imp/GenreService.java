package com.musicstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.GenreDAO;
import com.musicstore.entity.Genre;
import com.musicstore.service.IGenreService;
@Service(value = "genreService")
public class GenreService implements IGenreService{
	@Autowired
	private GenreDAO genreDAO;
	@Override
	public Genre findByName(String name) {
		// TODO Auto-generated method stub
		return genreDAO.findByName(name);
	}
	@Override
	public List<Genre> findAll() {
		// TODO Auto-generated method stub
		return (List<Genre>) genreDAO.findAll();
	}
	@Override
	public Genre save(Genre g) {
		// TODO Auto-generated method stub
		return genreDAO.save(g);
	}
}
