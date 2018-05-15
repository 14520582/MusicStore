package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.Genre;
import com.musicstore.service.IGenreService;
@RestController
@RequestMapping("/genre")
public class GenreController {
	@Autowired
	private IGenreService genreService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Genre> findAll() {
		List<Genre> list = genreService.findAll();
		return list;
	}
}
