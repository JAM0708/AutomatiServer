package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Car;
import com.automati.dataentity.Model;
import com.automati.dataentity.Person;
import com.automati.dataentity.Review;

public interface ReviewServiceInterface extends GenericServiceInterface {
	
	
	public List<Review> getReviewsByModel(Model model);
	
	public Review getReviewByCar(Car car);
	
	public List<Review> getReviewsByPerson(Person person);
}
