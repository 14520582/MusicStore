package com.musicstore.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Song;

@Repository
public interface SongDAO extends CrudRepository<Song, Integer>{

}
