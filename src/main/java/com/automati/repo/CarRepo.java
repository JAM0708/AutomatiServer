package com.automati.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Car;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Transmission;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
	
	List<Car> findCarsByPerson(Person person);
	
	List<Car> findCarByModel(Model model);
	
}
