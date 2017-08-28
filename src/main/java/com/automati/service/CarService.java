package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.repo.CarRepo;
import com.automati.service.interfaces.CarServiceInterface;

@Service
@Transactional
public class CarService implements CarServiceInterface {

	@Autowired
	private CarRepo carRepo;
	
	@Override
	public void saveCar(Car car) {
		carRepo.save(car);

	}

	@Override
	public Car getCar(int index) {
		// TODO update if not neeeded
		return carRepo.getOne(index);
	}

	@Override
	public List<Car> getCars(Person person) {
		// TODO get logger for class
		return carRepo.findCarByPerson(person);
		
	}

	@Override
	public void updateCar(Car car) {
		carRepo.saveAndFlush(car);
	}

	@Override
	public void deleteCar(Car car) {
		carRepo.delete(car);
	}

}
