package com.automati.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.automati.dataentity.Car;

public interface CarRepo extends JpaRepository<Car, Integer> {

}
