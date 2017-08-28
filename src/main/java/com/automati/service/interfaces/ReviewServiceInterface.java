package com.automati.service.interfaces;

import java.util.List;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;

public interface ReviewServiceInterface {
	
	public void addReview(Review review);
	
	public void updateReview(Review review);
	
	public void deleteReview(Review review);
	
	public List<Review> getReviews(Person person);
}
