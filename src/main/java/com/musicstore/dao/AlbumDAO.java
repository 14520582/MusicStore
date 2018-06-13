package com.musicstore.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    
    @Query("SELECT t FROM Album t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.artist.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.genre.name) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    public Page<Album> findBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
    
    @Query("SELECT t FROM Album t WHERE " +
            "LOWER(t.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.artist.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.genre.name) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    public Page<Album> clientFindBySearchTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
    
    @Query("SELECT t FROM Album t WHERE LOWER(t.artist.country.name) LIKE LOWER(CONCAT('%',:country, '%'))")
    public Page<Album> findByCountry(@Param("country") String country, Pageable pageable);
    
    @Query("SELECT t FROM Album t WHERE t.artist.id = :id")
    public Page<Album> findByArtist(@Param("id") int id, Pageable pageable);
    
    @Query("SELECT t FROM Album t WHERE t.genre.id = :id")
    public Page<Album> findByGenre(@Param("id") int id, Pageable pageable);
    
    public Page<Album> findAll(Pageable pageable);
    
    public long count();
    
}
