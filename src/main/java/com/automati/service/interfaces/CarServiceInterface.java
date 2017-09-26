package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.*;

public interface CarServiceInterface extends GenericServiceInterface {
	
	public Car getCar(int index);
	
	public List<Car> getCars(Person person);
	

}
