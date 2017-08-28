package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {
	List<Person> findPeople();	
	Person findPersonByIndex(int index);
}
