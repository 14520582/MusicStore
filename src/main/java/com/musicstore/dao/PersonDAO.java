package com.musicstore.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicstore.entity.Person;
@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>{
//    List<Person> getAllPersons();
    public Person findOne(int pid);
//    void addPerson(Person person);
//    void updatePerson(Person person);
//    void deletePerson(int pid);
//    boolean personExists(String name, String location);
}
 