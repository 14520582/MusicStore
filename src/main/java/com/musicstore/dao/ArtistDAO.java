package com.musicstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Artist;

@Repository
public interface ArtistDAO extends CrudRepository<Artist, Integer>{

}
