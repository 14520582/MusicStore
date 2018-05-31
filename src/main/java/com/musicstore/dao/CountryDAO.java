package com.musicstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Artist;
import com.musicstore.entity.Country;

@Repository
public interface CountryDAO extends CrudRepository<Country, Integer>{

}
