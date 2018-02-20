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

	public Car getCarById(int id);
	
	public List<Color> getAllColors();
	
	public List<Transmission> getAllTransmissions();
	
	public List<Feature> getAllFeatures();
	
	public Color getColorByName(String name);
	
	public Transmission getTransmission(int id);
	
	public Engine getEngine(int id);
	
	public List<Engine> getAllEngines();
	
	public List<Car> getCarsByPerson(Person person);
}
