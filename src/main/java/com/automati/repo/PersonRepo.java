package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;



import com.automati.dataentity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
