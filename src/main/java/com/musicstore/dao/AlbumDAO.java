package com.musicstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import com.musicstore.entity.Album;

@Repository
public interface AlbumDAO  extends CrudRepository<Album, Integer>{
    @Query("select u from Album u where u.name = ?1")
    public Album findByName(String name);
    @Query("SELECT COUNT(e)>0 FROM Album e WHERE e.name=?1")
    public boolean existsByName(String name);
    @Query("SELECT e FROM Album e WHERE e.genre.name = :nameGenre")
    public List<Album> getAlbumByGenre(@Param("nameGenre") String nameGenre);
}
