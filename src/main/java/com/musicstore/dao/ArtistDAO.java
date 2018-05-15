package com.musicstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Artist;

@Repository
public interface ArtistDAO extends CrudRepository<Artist, Integer>{
    @Query("select u from Artist u where u.name = ?1")
    public Artist findByName(String name);
    @Query("SELECT COUNT(e)>0 FROM Artist e WHERE e.name=?1")
    public boolean existsByName(String name);
//    @Query("SELECT e FROM Artist e WHERE e.genre.name = :nameGenre")
//    public List<Album> getArtistByGenre(@Param("nameGenre") String nameGenre);
}
