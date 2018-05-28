package com.musicstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.OrderDAO;
import com.musicstore.dao.SongDAO;
import com.musicstore.entity.Song;
import com.musicstore.service.ISongService;
@Service(value = "songService")
public class SongService implements ISongService{
	@Autowired
	private SongDAO songDAO;
	@Override
	public List<Song> findAll() {
		// TODO Auto-generated method stub
		return (List<Song>) songDAO.findAll();
	}

}
