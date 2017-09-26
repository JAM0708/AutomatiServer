package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;

public interface ReviewServiceInterface extends GenericServiceInterface {
	
	public List<Review> getReviews(Person person);
}
