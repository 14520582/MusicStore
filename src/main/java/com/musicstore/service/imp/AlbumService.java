package com.musicstore.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.musicstore.service.*;
import com.musicstore.dao.AlbumDAO;
import com.musicstore.entity.Album;
@Service(value = "albumService")
public class AlbumService implements IAlbumService{
	@Autowired
	private AlbumDAO albumDAO;
	@Override
	public List<Album> getAlbumByGenre(String genreName) {
		return albumDAO.getAlbumByGenre(genreName);
	}
	@Override
	public List<Album> findAll() {
		return (List<Album>) albumDAO.findAll();
	}
	@Override
	public Album findByName(String name) {
		// TODO Auto-generated method stub
		return albumDAO.findByName(name);
	}
	@Override
	public boolean addAlbum(Album album) {
	       if (albumDAO.existsByName(album.getName())) {
	    	   return false;
	       } else {
	    	   albumDAO.save(album);
	    	   return true;
	       }
	}
	@Override
	public Album update(Album album) {
		return albumDAO.save(album);
		
	}
	@Override
	public Album getAlbumById(int id) {
		return albumDAO.findOne(id);
	}
	@Override
	public Page<Album> findByPage(Pageable pageable) {
//		List<Album> all = (List<Album>) albumDAO.findAll();
//		long len = albumDAO.count();
//		System.out.println(len);
	//	return albumDAO.findByPage(page, pagesize);
//		Paging a = new Paging(albumDAO.findByPage((page-1)*pagesize, pagesize), albumDAO.count());
//	    System.out.println("dfs" + page);
//	    return a;
		
		return albumDAO.findAll(pageable);
	}
	@Override
	public Page<Album> findBySearchTerm(String term, Pageable pageable) {
		// TODO Auto-generated method stub
		return albumDAO.findBySearchTerm(term, pageable);
	}

}
