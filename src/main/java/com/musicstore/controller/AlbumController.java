package com.musicstore.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.Album;
import com.musicstore.service.IAlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	private IAlbumService albumService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/{genre}", method = RequestMethod.GET)
	public List<Album> getAllPersons(@PathVariable("genre") String genre) {
		List<Album> list = albumService.getAlbumByGenre(genre);
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Album> findAll() {
		List<Album> list = albumService.findAll();
		return list;
	}
}
