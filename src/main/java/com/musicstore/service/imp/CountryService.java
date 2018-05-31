package com.musicstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.CountryDAO;
import com.musicstore.entity.Country;
import com.musicstore.service.ICountryService;

@Service(value = "countryService")
public class CountryService implements ICountryService {
	@Autowired
	private CountryDAO countryDAO;
	@Override
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return (List<Country>) countryDAO.findAll();
	}

}
