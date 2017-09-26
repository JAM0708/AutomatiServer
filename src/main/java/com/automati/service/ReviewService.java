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
	public List<Review> getReviews(Person person) {
		return reviewRepo.findReviewsByPerson(person);
	}

	@Override
	public <T> void save(T object) {
		if (object instanceof Review) {
			reviewRepo.save((Review) object);
		}
	}

	@Override
	public <T> void delete(T object) {
		if (object instanceof Review) {
			reviewRepo.delete((Review) object);
		}
	}

	@Override
	public <T> void update(T object) {
		if (object instanceof Review) {
			reviewRepo.save((Review) object);
		}
	}

}
