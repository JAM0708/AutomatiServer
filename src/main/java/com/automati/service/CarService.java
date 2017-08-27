package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;
import com.automati.repo.CarRepo;
import com.automati.service.interfaces.CarServiceInterface;

public class CarService implements CarServiceInterface {

	@Autowired
	private CarRepo carRepo;
	
	@Override
	public void saveCar(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public Car getCar(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCars(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCar(Car car) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCar(Car car) {
		// TODO Auto-generated method stub

	}

}
