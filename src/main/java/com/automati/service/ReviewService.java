package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.repo.ReviewRepo;
import com.automati.service.interfaces.ReviewServiceInterface;

@Service
@Transactional
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Override
	public void addReview(Review review) {
		reviewRepo.save(review);
	}

	@Override
	public void updateReview(Review review) {
		reviewRepo.saveAndFlush(review);
	}

	@Override
	public void deleteReview(Review review) {
		reviewRepo.delete(review);
	}

	@Override
	public List<Review> getReviews(Person person) {
		return reviewRepo.findReviewsByPerson(person);
	}

}
