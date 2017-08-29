package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.*;

public interface CarServiceInterface {
	
	public void saveCar(Car car);
	
	public Car getCar(int index);
	
	public List<Car> getCars(Person person);
	
	public void updateCar(Car car);
	
	public void deleteCar(Car car);
	
	public void saveTransmission(Transmission transmission);
	
	public void saveColor(Color color);
	
	public void saveFeature(Feature feature);
	
	public void saveLease(Lease lease);
	
	public void saveEPA(EPA epa);
	
	public void saveModel(Model model);
	
	public void saveCondition(Condition condition);
	

}
