package com.musicstore.service;

import com.musicstore.entity.Person;

public interface IPersonService {
     Person getPersonById(int pid);
     boolean addPerson(Person person);
}
