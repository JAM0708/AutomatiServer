package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.*;

public interface CarServiceInterface extends GenericServiceInterface {
	
	public Car getCar(int index);
	
	public List<Car> getCars(Person person);
	
	public List<Model> getAllModels();
	
	public List<Car> getCarsByModel(String model);
	
	public Model getModelByName(String name);

	public Transmission getTransmissionByName(String name);

	public Condition getConditionByType(String type);

	public EPA getEPAByMileage(int mileage);
}
