package com.musicstore.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.musicstore.entity.Account;
import com.musicstore.entity.Album;
import com.musicstore.entity.Artist;
import com.musicstore.entity.Song;
import com.musicstore.service.IAlbumService;
import com.musicstore.service.IArtistService;
import com.musicstore.service.IGenreService;
@CrossOrigin
@RestController
@RequestMapping("/album")
public class AlbumController {
	@Autowired
	private IAlbumService albumService;
	@Autowired
	private IArtistService artistService;
	@Autowired
	private IGenreService genreService;
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/genre/{genre}", method = RequestMethod.GET)
	public List<Album> getAlbumByGenre(@PathVariable("genre") String genre) {
		List<Album> list = albumService.getAlbumByGenre(genre);
		return list;
	}
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public List<Album> findAll() {
		List<Album> list = albumService.findAll();
		return list;
	}
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<Album> findPage(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize) {
    	Pageable pageable = new PageRequest(page, pageSize, Sort.Direction.DESC, "id");
    	return albumService.findByPage(pageable);
    }
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<Album> findBySearchTerm(@RequestParam("page") int page, @RequestParam("pagesize") int pageSize, @RequestParam("term") String term) {
    	Pageable pageable = new PageRequest(page, pageSize);
    	return albumService.findBySearchTerm(term, pageable);
    }
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET)
	public Album getByName(@RequestParam("name") String name) {
		Album album = albumService.findByName(name);
		return album;
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public Album addAlbum(@RequestBody Album album) {
		List<Song> songs = new ArrayList<Song>(album.getSongs());
		album.clearSongs();
		for (Iterator<Song> i = songs.iterator(); i.hasNext();) {
			Song item = i.next();
		    Song t = new Song(item.getName(), item.getGenre(), item.getSinger());
		    t.setAlbum(album);
		    System.out.println(item.getName());
		    album.addSong(t);
		}
        return albumService.addAlbum(album);
	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value= "/changestatus", method = RequestMethod.PUT)
	public Album changeStatus(@RequestParam("id") int id) {
		Album album = albumService.getAlbumById(id);
		int status = album.getStatus() == 1 ? 0 : 1;
		album.setStatus(status);
		return albumService.update(album);
	}
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
//	@RequestMapping(value= "/changestatus", method = RequestMethod.GET)
//	public ResponseEntity<Album> getAlbumById(@PathVariable("id") Integer id) {
//		Album album = albumService.getAlbumById(id);
//		return new ResponseEntity<Album>(album, HttpStatus.OK);
//	}
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value= "/edit",method = RequestMethod.PUT)
	public Album editAlbum(@RequestBody Album album) {
		Album t = albumService.getAlbumById(album.getId());
		t.setArtist(album.getArtist());
		t.setCover(album.getCover());
		t.setDescription(album.getDescription());
		t.setGenre(album.getGenre());
		t.setName(album.getName());
		t.setPrice(album.getPrice());
		t.setReleasedate(album.getReleasedate());
		t.setQuantity(album.getQuantity());
		return albumService.addAlbum(t);
	}
}
