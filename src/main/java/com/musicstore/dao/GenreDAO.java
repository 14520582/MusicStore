package com.musicstore.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Genre;

@Repository
public interface GenreDAO extends CrudRepository<Genre, Integer>{
    @Query("select u from Genre u where u.name = ?1")
    public Genre findByName(String name);
}
