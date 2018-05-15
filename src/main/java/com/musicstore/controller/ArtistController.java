package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.Album;
import com.musicstore.entity.Artist;
import com.musicstore.service.IArtistService;
@RestController
@RequestMapping("/artist")
public class ArtistController {
	@Autowired
	private IArtistService artistService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/{genre}", method = RequestMethod.GET)
	public Artist getArtistByName(@PathVariable("name") String name) {
		Artist artist = artistService.findByName(name);
		return artist;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Artist> findAll() {
		List<Artist> list = artistService.findAll();
		return list;
	}
}
