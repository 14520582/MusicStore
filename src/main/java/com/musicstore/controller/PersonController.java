package com.musicstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.musicstore.entity.Person;
import com.musicstore.service.IPersonService;

@RestController
@RequestMapping("test")
public class PersonController {
	@Autowired
	private IPersonService personService;
	@RequestMapping(value="/person/{id}", method = RequestMethod.GET )
	public ResponseEntity<Person> getPersonById(@PathVariable("id") Integer id) {
		Person person = personService.getPersonById(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}
	@RequestMapping(value= "/person", method = RequestMethod.POST)
	public ResponseEntity<Void> addAccount(@RequestBody Person person, UriComponentsBuilder builder) {
        boolean flag = personService.addPerson(person);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/person/{id}").buildAndExpand(person.getPid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
} 