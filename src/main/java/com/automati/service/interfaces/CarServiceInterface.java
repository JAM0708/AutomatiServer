package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Car;
import com.automati.dataentity.Person;

public interface CarServiceInterface {
	
	public void saveCar(Car car);
	
	public Car getCar(int index);
	
	public List<Car> getCars(Person person);
	
	public void updateCar(Car car);
	
	public void deleteCar(Car car);

}
