package com.musicstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.musicstore.entity.Artist;
import com.musicstore.entity.Country;
import com.musicstore.service.IArtistService;
import com.musicstore.service.ICountryService;

@RestController
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private ICountryService countryService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Country> findAll() {
		List<Country> list = countryService.findAll();
		return list;
	}
}
