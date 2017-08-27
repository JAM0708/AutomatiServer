package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automati.dataentity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {

}
