package com.musicstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musicstore.dao.PersonDAO;
import com.musicstore.entity.Account;
import com.musicstore.entity.Person;
@Service
public class PersonService implements IPersonService {
	@Autowired
	private PersonDAO personDAO;
	@Override
	public Person getPersonById(int pid) {
		Person obj = personDAO.findOne(pid);
		return obj;
	}
	@Override
	public synchronized boolean addPerson(Person per) {
	    	   personDAO.save(per);
	    	   return true;
	}
}
