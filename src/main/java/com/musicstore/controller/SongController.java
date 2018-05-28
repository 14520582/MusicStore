package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.Song;
import com.musicstore.service.ISongService;

@RestController
@RequestMapping("/song")
public class SongController {
	@Autowired
	private ISongService songService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Song> findAll() {
		List<Song> list = songService.findAll();
		return list;
	}
}
