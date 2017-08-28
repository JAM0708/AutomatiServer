package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
	
	List<Car> findCarByPerson(Person person);
}
