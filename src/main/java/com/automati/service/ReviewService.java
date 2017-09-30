package com.automati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automati.dataentity.Person;
import com.automati.dataentity.Review;
import com.automati.dto.StatusCheck;
import com.automati.repo.ReviewRepo;
import com.automati.service.interfaces.ReviewServiceInterface;

@Service
@Transactional
public class ReviewService implements ReviewServiceInterface {

	@Autowired
	private ReviewRepo reviewRepo;
	
	@Autowired
	@Qualifier("status-check")
	private StatusCheck status;

	@Override
	public List<Review> getReviews(Person person) {
		return reviewRepo.findReviewsByPerson(person);
	}

	@Override
	public <T> StatusCheck save(T object) {
		boolean passed = false;
		if (object instanceof Review) {
			reviewRepo.save((Review) object);
			status.setPassedTrue();
			return status;
		} else {
			status.setPassedFalse();
			return status;
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
